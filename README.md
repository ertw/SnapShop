 I had a lot of fun working on this project. After a few refactors, I'm pretty happy with the interfaces I've created.

 I tracked my progress in this repo: https://github.com/ertw/SnapShop
 
 Some notes:
 - Created a Kernel class to represent and apply a convolution matrix. This allows me to easily create new matrix style filters by defining a matrix.
 - Added Pixel.normalize(Consumer<Pixel> consumer) to Pixel.java, which accepts a function that takes a Pixel and potentially modifies it.
 - Added PixelImage.transform(Consumer<Pixel> consumer) to PixelImage.java, which allows me to define a function to apply to each pixel in an entire image.
 - I support arbitrarily sized convolution matrices, but I've only tested through 5x5. I didn't find any interesting effects with larger convolutions, so I've only used 3x3 matrices.

 Beyond the basic filters, I added a few more:
 - QuantizeFilter: Quantiles the image to a given number of colors.
 - EmbossFilter: Applies an emboss effect to the image.
 The emboss filter was the most difficult one for me to implement, because I initially tried embossing with just the convolution weights. I eventually discovered
 that I needed to apply a bias to each pixel transformation. Fortunately, Java's method overloading allowed me to create a Kernel constructor that accepts a bias.
 Because the filters compose, I was able to pass the emboss filter a greyscale filter, which results in a final image that is identical to that produced in common
 image manipulation programs.

Building with Maven:

* Build: `mvn clean compile assembly:single`
* Run: `java -jar target/SnapShop-1.0-SNAPSHOT-jar-with-dependencies.jar`

Tested with:
* Maven 3.9.5
* Java 21