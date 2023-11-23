/**
 * Filter that quantiles an image.
 */
public class QuantizeFilter implements Filter {
    public void filter(PixelImage pixelImage) {
        int numLevels = 4;
        int numBins = 256 / numLevels;
        pixelImage.transform((p) -> {
            p.red = (p.red / numBins) * numBins;
            p.green = (p.green / numBins) * numBins;
            p.blue = (p.blue / numBins) * numBins;
        });
    }
}
