/**
 * Filter that applies an edge detect filter to an image.
 */
public class EdgeDetectFilter implements Filter {
    public void filter(PixelImage pixelImage) {
        final int[][] matrix = {
                {0, 1, 0},
                {1, -4, 1},
                {0, 1, 0}};
        Kernel kernel = new Kernel(matrix);
        kernel.applyTo(pixelImage);
    }
}
