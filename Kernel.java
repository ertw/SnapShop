/**
 * Kernel class for applying a convolution matrix to an image.
 */
public class Kernel {
    /**
     * The matrix to apply to the image.
     */
    private final int[][] matrix;
    /**
     * The width of the matrix.
     */
    private final int width;
    /**
     * The height of the matrix.
     */
    private final int height;
    /**
     * The sum of all the values in the matrix.
     * This is used to normalize the resulting pixel.
     */
    private final int sum;

    /**
     * Create a new kernel with the given matrix.
     *
     * @param matrix The convolution matrix to apply to the image.
     */
    public Kernel(int[][] matrix) {
        this.matrix = matrix;
        this.width = matrix.length;
        this.height = matrix[0].length;
        this.sum = calculateSum(matrix);
    }

    /**
     * Calculate the sum of all the values in the matrix.
     *
     * @param matrix The convolution matrix to calculate the sum of.
     * @return The sum of all the values in the matrix.
     */
    private int calculateSum(int[][] matrix) {
        int total = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                total += anInt;
            }
        }
        return total;
    }

    /**
     * Apply the convolution matrix to the given pixel.
     *
     * @param row  The row of the pixel to apply the matrix to.
     * @param col  The column of the pixel to apply the matrix to.
     * @param data The image data to apply the matrix to.
     * @return The new pixel after applying the matrix.
     */
    private Pixel convolve(int row, int col, Pixel[][] data) {
        Pixel newPixel = new Pixel(0, 0, 0);
        for (int mx = 0; mx < width; mx++) {
            for (int my = 0; my < height; my++) {
                int imageX = row + mx - width / 2;
                int imageY = col + my - height / 2;
                if (imageX >= 0 && imageX < data.length && imageY >= 0 && imageY < data[0].length) {
                    Pixel pixel = data[imageX][imageY];
                    int kernelValue = matrix[mx][my];
                    newPixel.red += pixel.red * kernelValue;
                    newPixel.green += pixel.green * kernelValue;
                    newPixel.blue += pixel.blue * kernelValue;
                }
            }
        }
        newPixel.red = normalize(newPixel.red);
        newPixel.green = normalize(newPixel.green);
        newPixel.blue = normalize(newPixel.blue);
        return newPixel;
    }

    private int normalize(int value) {
        if (sum == 0) {
            return Math.clamp(value, 0, 255);
        }
        return Math.clamp(value / sum, 0, 255);
    }

    /**
     * Apply the convolution matrix to the given image.
     *
     * @param pixelImage The image to apply the matrix to.
     */
    public void applyTo(PixelImage pixelImage) {
        Pixel[][] data = pixelImage.getData();
        Pixel[][] result = pixelImage.getData(); // deposit result here to prevent overwriting pixels that haven't been convolved yet
        final int imageHeight = pixelImage.getHeight();
        final int imageWidth = pixelImage.getWidth();
        final int offset = Math.max(width, height) / 2; // prevent out of bounds
        for (int row = offset; row < imageHeight - offset; row++) {
            for (int col = offset; col < imageWidth - offset; col++) {
                Pixel newPixel = convolve(row, col, data);
                result[row][col] = newPixel;
            }
        }
        pixelImage.setData(result);
    }
}