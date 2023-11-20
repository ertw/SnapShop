/**
 * I had a lot of fun working on this project. After a few refactors, I'm pretty happy with the interfaces I've created.
 * I tracked my progress in this repo: https://github.com/ertw/SnapShop
 * Some notes:
 * - Created a Kernel class to represent and apply a convolution matrix. This allows me to easily create new matrix style filters by defining a matrix.
 * - Added Pixel.normalize(Consumer<Pixel> consumer) to Pixel.java, which accepts a function that takes a Pixel and potentially modifies it.
 * - Added PixelImage.transform(Consumer<Pixel> consumer) to PixelImage.java, which allows me to define a function to apply to each pixel in an entire image.
 * Beyond the basic filters, I also added a quantize filter, which I think looks pretty cool.
 */

/**
 * A class to configure the SnapShop application
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SnapShopConfiguration {
    /**
     * Method to configure the SnapShop.  Call methods like addFilter
     * and setDefaultFilename here.
     *
     * @param theShop A pointer to the application
     */
    public static void configure(SnapShop theShop) {

//        theShop.setDefaultFilename("program_9/billg.jpg");
        theShop.setDefaultFilename("c:/users/cd/desktop/jpegs/billg.jpg");
        theShop.addFilter(new FlipHorizontalFilter(), "Flip Horizontal");
        theShop.addFilter(new FlipVerticalFilter(), "Flip Vertical");
        theShop.addFilter(new NegativeFilter(), "Negative");
        theShop.addFilter(new GaussianBlurFilter(), "Gaussian Blur");
        theShop.addFilter(new LaplacianFilter(), "Laplacian");
        theShop.addFilter(new UnsharpenFilter(), "Usharp Masking");
        theShop.addFilter(new EdgyFilter(), "Edgy");
        theShop.addFilter(new EmbossFilter(), "Emboss");
        theShop.addFilter(new GreyscaleFilter(), "Greyscale");
        theShop.addFilter(new EdgeDetectFilter(), "Edge Detect");
        theShop.addFilter(new QuantizeFilter(), "Quantize");
    }
}
