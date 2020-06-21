
/**
 * Shifts the picture right by one pixel.
 * 
 * @author Jonathan Liao
 * @version 3/29/2015
 */
public class ShiftRightFilter implements Filter
{
    // No instance variables
  
    /** 
     * filter
     * 
     * Shifts image right by 1 pixel
     * 
     * @param pi The PixelImage object to modify
     */
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();  // Gets image data
        Pixel[][] temp = pi.getData();  // Temporary data
        for (int row = pi.getHeight() -1; row >= 0; row--) {
            for (int col = pi.getWidth() -1; col >= 0; col--) {
                if (col == 0){
                    temp[row][col] = data[row][pi.getWidth()-1];
                }
                else {
                    temp[row][col] = data[row][col-1];
                }
            }// Moves everything right
        }  
        
        pi.setData(temp);
    }//filter
}
