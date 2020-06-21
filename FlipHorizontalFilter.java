
/**
 * Filter that flips the image horizontally.
 * 
 * @author Jonathan Liao
 * @version 3/29/2015
 */
public class FlipHorizontalFilter implements Filter
{
    // No instance variables

    /** 
     * filter
     * flips pixel image horizontally around horizontal center line
     * 
     * @param pi The PixelImage object to flip
     */
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();  // Gets image data

        for (int row = 0; row < pi.getHeight(); row++) {
            for (int col = 0; col < pi.getWidth() / 2; col++) {
                // Swap values across the vertical line
                Pixel initial = data[row][col];
                data[row][col] = data[row][pi.getWidth() - col - 1];
                data[row][pi.getWidth() - col - 1] = initial;
            }
        }  
        
        pi.setData(data);
        // Assings changed data to PixelImage data
    }
}

