
/**
 * Filter that creates a negative of the photo by taking opposite magnitude of color intensity for RGB
 * 
 * @author Jonathan Liao
 * @version 3/29/2015
 */
public class NegativeFilter implements Filter
{
    // No instance variables

    /** 
     * filter
     * 
     * Analyzes the pizels and creates a stippled image
     * 
     * @param pi The PixelImage object to modify
     */
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();  // Gets image data

        for (int row = 0; row < pi.getHeight(); row++) {
            for (int col = 0; col < pi.getWidth(); col++) {
                data[row][col].setAllColors(255 - data[row][col].getRed(), 255 - data[row][col].getGreen(), 255 - data[row][col].getBlue());
            }
        } // Converts the image to the negative of it

        pi.setData(data);
        // Assigns changed data to PixelImage data
    }
}

