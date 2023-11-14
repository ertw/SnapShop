/**
 * Filter that applies a Laplacian filter to an image.
 */
public class LaplacianFilter implements Filter {
    public void filter(PixelImage pixelImage) {
        final int[][] matrix = {
                {-1, -1, -1},
                {-1, 8, -1},
                {-1, -1, -1}};
        Kernel kernel = new Kernel(matrix);
        kernel.applyTo(pixelImage);
    }
}
