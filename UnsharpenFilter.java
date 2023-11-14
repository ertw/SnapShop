/**
 * Filter that applies an unsharpen filter to an image.
 */
public class UnsharpenFilter implements Filter {
    public void filter(PixelImage pixelImage) {
        final int[][] matrix = {
                {-1, -2, -1},
                {-2, 28, -2},
                {-1, -2, -1}};
        Kernel kernel = new Kernel(matrix);
        kernel.applyTo(pixelImage);
    }
}
