/**
 * Filter that applies a Laplacian filter to an image.
 */
public class LaplacianFilter implements Filter {
    public void filter(PixelImage pixelImage) {
        final int[][] laplacianKernel = {
                {-1, -1, -1},
                {-1, 8, -1},
                {-1, -1, -1}};
        Kernel kernel = new Kernel(laplacianKernel);
        kernel.applyTo(pixelImage);
    }
}
