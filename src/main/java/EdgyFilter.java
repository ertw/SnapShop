/**
 * Filter that applies an edgy filter to an image.
 */
public class EdgyFilter implements Filter {
    public void filter(PixelImage pixelImage) {
        final int[][] matrix = {
                {-1, -1, -1},
                {-1, 9, -1},
                {-1, -1, -1}};
        Kernel kernel = new Kernel(matrix);
        kernel.applyTo(pixelImage);
    }
}
