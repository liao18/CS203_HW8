
/**
 * Write a description of class DemosaicFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DemosaicFilter implements Filter
{
   public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();  // get image data
    
        for (int row = 0; row < pi.getHeight(); row++) {
            for (int col = 0; col < pi.getWidth(); col++) {
                int redSum = 0;
                int redInst = 0;
                int blueSum = 0;
                int blueInst = 0;
                int greenSum = 0;
                int greenInst = 0;
                
                switch (data[row][col].getDigCamColor() ) {
                    case 0: //all pixel values are already present. No need to change any values
                    break;
                
                    case 1: //R value is present; need B and G
                    for(int i = -1; i <= 1; i++) {
                        for(int j = -1; j <= 1; j++) {
                            try {
                                //check for B
                                if (data[row + i][col + j].getDigCamColor() == 0 || data[row + i][col + j].getDigCamColor() == 3) {
                                    blueSum += data[row + i][col + j].getBlue();
                                    blueInst++;
                                }
                                //check for G
                                if (data[row + i][col + j].getDigCamColor() == 0 || data[row + i][col + j].getDigCamColor() == 2) {
                                    greenSum += data[row + i][col + j].getGreen();
                                    greenInst++;
                                }
                            } 
                            catch (ArrayIndexOutOfBoundsException e) {
                                //do nothing for out of bounds
                            }
                        }
                    }
                    
                    data[row][col].setBlue(blueSum/blueInst);
                    data[row][col].setGreen(greenSum/greenInst);
                    break;
                    
                    case 2: //G value is present; need R and B
                    for(int i = -1; i <= 1; i++) {
                        for(int j = -1; j <= 1; j++) {
                            try {
                                //check for R
                                if (data[row + i][col + j].getDigCamColor() == 0 || data[row + i][col + j].getDigCamColor() == 1) {
                                    redSum += data[row + i][col + j].getRed();
                                    redInst++;
                                }
                                //check for B
                                if (data[row + i][col + j].getDigCamColor() == 0 || data[row + i][col + j].getDigCamColor() == 3) {
                                    blueSum += data[row + i][col + j].getBlue();
                                    blueInst++;
                                }
                            } 
                            catch (ArrayIndexOutOfBoundsException e) {
                                //do nothing for out of bounds
                            }
                        }
                    }
                    data[row][col].setBlue(blueSum/blueInst);
                    data[row][col].setRed(redSum/redInst);
                    break;
                    
                    case 3: //B value is present; need R and G
                    for(int i = -1; i <= 1; i++) {
                        for(int j = -1; j <= 1; j++) {
                            try {
                                //check for R
                                if (data[row + i][col + j].getDigCamColor() == 0 || data[row + i][col + j].getDigCamColor() == 1) {
                                    redSum += data[row + i][col + j].getRed();
                                    redInst++;
                                }
                                //check for G
                                if (data[row + i][col + j].getDigCamColor() == 0 || data[row + i][col + j].getDigCamColor() == 2) {
                                    greenSum += data[row + i][col + j].getGreen();
                                    greenInst++;
                                }
                            } 
                            catch (ArrayIndexOutOfBoundsException e) {
                                //do nothing for out of bounds
                            }
                        }
                    }
                    data[row][col].setRed(redSum/redInst);
                    data[row][col].setGreen(greenSum/greenInst);
                    break;
                }
                
                }
            }
             pi.setData(data);
        // Assigns filtered picture data to PixelImage data
        }  
    }

