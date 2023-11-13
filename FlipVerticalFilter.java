/**
 * Filter that flips the image vertically.
 */
public class FlipVerticalFilter implements Filter {
    public void filter(PixelImage image) {
        Pixel[][] data = image.getData();
        final int height = image.getHeight();
        final int width = image.getWidth();
        Pixel temp = null;

        for (int row = 0; row < height / 2; row++) {
            for (int col = 0; col < width; col++) {
                temp = data[row][col];
                data[row][col] = data[height - row - 1][col];
                data[height - row - 1][col] = temp;
            }
        }
        image.setData(data);
    }
}
