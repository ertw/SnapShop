/**
 * Filter that applies a negative filter to an image.
 */
public class NegativeFilter implements Filter {
    public void filter(PixelImage pixelImage) {
        pixelImage.transform((p) -> {
            p.red = 255 - p.red;
            p.green = 255 - p.green;
            p.blue = 255 - p.blue;
        });
    }
}
