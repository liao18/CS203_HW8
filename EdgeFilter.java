
/**
 * Filter that detects edges and creates a coloring-book image
 * 
 * @author Jonathan Liao
 * @version 3/29/2015
 */
public class EdgeFilter implements Filter
{
    public static final boolean EDGE = true;
    public static final boolean FILL = false;

    /** 
     * filter
     * 
     * Analyzes the pizels and creates a black/white image
     * 
     * @param pi The PixelImage object to modify
     */
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();  // Gets image data
        boolean[][] edges = new boolean[pi.getHeight()][pi.getWidth()]; // Records what kind of pixel is in this slot
        int[][] brightness = new int[pi.getHeight()][pi.getWidth()]; // Records the brightness of the pixel in this slot

        for (int i = 0; i < pi.getHeight(); i++) {
            for (int j = 0; j < pi.getWidth(); j++) {
                edges[i][j] = FILL;
            }
        }  // Sets the edges array to all fillers

        for (int i = 0; i < pi.getHeight(); i++) {
            for (int j = 0; j < pi.getWidth(); j++) {
                //formula for calculating Luminance is = (0.299*R + 0.587*G + 0.114*B)
                brightness[i][j] =  (int)( (.299)*(data[i][j].getRed()) + (.587)*(data[i][j].getGreen()) + (.114)*(data[i][j].getBlue())  );
            }
        }  // Sets the brightness array

        for (int row = 0; row < pi.getHeight(); row++) {
            for (int col = 0; col < pi.getWidth(); col++) {
                
                for (int k = -1; k <= 1; k++) {
                    for (int h = -1; h <= 1; h++) {
                        if (edges[row][col] == FILL){
                            try {
                                if (Math.abs(brightness[row][col] - brightness[row+k][col+h]) >= 20) { //if the absolute difference of brightness between these two is greater than or equal to 20
                                    edges[row][col] = EDGE;
                                }
                            }
                            catch (ArrayIndexOutOfBoundsException e){
                                // Skips the erroneous index
                            }
                        }
                    }
                }
            }
        }  // Determines where the edges are

        for (int row = 0; row < pi.getHeight(); row++) {
            for (int col = 0; col < pi.getWidth(); col++) {
                if (edges[row][col] == EDGE){
                    data[row][col].setAllColors(0,0,0); //set to WHITE
                }
                else if (edges[row][col] == FILL){
                    data[row][col].setAllColors(255,255,255); //set to BLACK
                }
            }
        }  // Sets the brightness array

        pi.setData(data);
        // Assings changed data to PixelImage data
    }
}
