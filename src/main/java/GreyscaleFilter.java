/**
 * Filter that applies a greyscale filter to an image.
 */
public class GreyscaleFilter implements Filter {
    public void filter(PixelImage pixelImage) {
        pixelImage.transform((p) -> {
            int weightedAverage = (int) (p.red * 0.3) + (int) (p.green * 0.59) + (int) (p.blue * 0.11) / 3; // values chosen to match human perception of color
            p.red = weightedAverage;
            p.green = weightedAverage;
            p.blue = weightedAverage;
        });
    }
}
