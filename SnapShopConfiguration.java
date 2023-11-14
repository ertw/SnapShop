// TODO Write your short report here (-2 if there is no report)

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

//    theShop.setDefaultFilename("c:/users/cd/desktop/jpegs/billg.jpg");
        theShop.setDefaultFilename("program_9/billg.jpg");
        theShop.addFilter(new FlipHorizontalFilter(), "Flip Horizontal");
        theShop.addFilter(new FlipVerticalFilter(), "Flip Vertical");
        // TODO: negative filter
        theShop.addFilter(new GaussianBlurFilter(), "Gaussian Blur");
        theShop.addFilter(new LaplacianFilter(), "Laplacian");
        theShop.addFilter(new UnsharpenFilter(), "Usharp Masking");
        theShop.addFilter(new EdgyFilter(), "Edgy");
//        theShop.addFilter(new EmbossFilter(), "Emboss");
        // TODO: emboss filter
        // TODO: B&W filter
    }
}
