/**
 * Filter that applies a Gaussian blur to an image.
 */
public class GaussianBlurFilter implements Filter {
    public void filter(PixelImage pixelImage) {
        final int[][] gaussianKernel = {
                {1, 2, 1},
                {2, 4, 2},
                {1, 2, 1}};
        Kernel kernel = new Kernel(gaussianKernel);
        kernel.applyTo(pixelImage);
    }
}
