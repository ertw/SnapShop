/**
 * Filter that applies an emboss filter to an image.
 */
public class EmbossFilter implements Filter {
    public void filter(PixelImage pixelImage) {
        final int[][] matrix = {
                {-1, -1, 0},
                {-1, 0, 1},
                {0, 1, 1}};
        Filter filter = new GreyscaleFilter();
        Kernel kernel = new Kernel(matrix, 128);
        kernel.applyTo(pixelImage);
        filter.filter(pixelImage);
    }
}
