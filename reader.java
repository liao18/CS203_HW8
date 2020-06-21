import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class reader {
    public static void main(String args[]) {
        
        String filename = "C:/Users/Jonathan/Documents/dmps/am_am.dump";
        String content = null;
        File file = new File(filename); //for ex foo.txt
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader !=null){reader.close();}
        }
        return content;
    }
}