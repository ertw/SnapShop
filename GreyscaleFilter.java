import java.util.Arrays;

/**
 * Filter that applies a greyscale filter to an image.
 */
public class GreyscaleFilter implements Filter {
    public void filter(PixelImage pixelImage) {
        pixelImage.transform((p) -> {
            int average = (p.red + p.green + p.blue) / 3;
//            int weightedAverage = (int) (p.red * 0.3) + (int) (p.green * 0.59) + (int) (p.blue * 0.11) / 3;
            p.red = average;
            p.green = average;
            p.blue = average;
        });
    }
}
