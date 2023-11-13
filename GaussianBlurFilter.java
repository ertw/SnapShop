/**
 * Filter that applies a Gaussian blur to an image.
 * Weights:
 * 1 2 1
 * 2 4 2
 * 1 2 1
 */
public class GaussianBlurFilter implements Filter {
    private static Pixel convolve(int row, int col, Pixel[][] data) {
        final int[][] kernel = {
                {1, 2, 1},
                {2, 4, 2},
                {1, 2, 1}
        };
        final int kernelSum = 16;
        Pixel NW = data[row - 1][col - 1];
        Pixel N = data[row - 1][col];
        Pixel NE = data[row - 1][col + 1];
        Pixel W = data[row][col - 1];
        Pixel C = data[row][col];
        Pixel E = data[row][col + 1];
        Pixel SW = data[row + 1][col - 1];
        Pixel S = data[row + 1][col];
        Pixel SE = data[row + 1][col + 1];
        final int newRed = (NW.red * 1 + N.red * 2 + NE.red * 1 +
                W.red * 2 + C.red * 4 + E.red * 2 +
                SW.red * 1 + S.red * 2 + SE.red * 1) / kernelSum;
        final int newGreen = (NW.green * 1 + N.green * 2 + NE.green * 1 +
                W.green * 2 + C.green * 4 + E.green * 2 +
                SW.green * 1 + S.green * 2 + SE.green * 1) / kernelSum;
        final int newBlue = (NW.blue * 1 + N.blue * 2 + NE.blue * 1 +
                W.blue * 2 + C.blue * 4 + E.blue * 2 +
                SW.blue * 1 + S.blue * 2 + SE.blue * 1) / kernelSum;
        return new Pixel(newRed, newGreen, newBlue);
    }

    public void filter(PixelImage image) {
        Pixel[][] data = image.getData();
        final int height = image.getHeight();
        final int width = image.getWidth();
        final int kernelSize = 3;
        final int kernelCenter = kernelSize / 2;

        for (int row = 20; row < height - 20; row++) {
            for (int col = 20; col < width - 20; col++) {
                Pixel currentPixel = data[row][col];
                Pixel newPixel = convolve(row, col, data);
                data[row][col] = newPixel;
            }
        }
        image.setData(data);
    }
}
