
import java.io.*;
import java.net.*;
import java.util.*;

class FileIO {
    
    public static void main(String argv[]) throws Exception {

        // get the current directory
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);

        //Write to a file -- FileOutputStream
        try (FileOutputStream outToFile = new FileOutputStream("outText.txt", true);) {// append the data if the argument is true

            //Message to write -- convert them to byte array
            String sentence = " Message to write";
            byte[] b = sentence.getBytes();
            outToFile.write(b, 0, b.length);
            
            outToFile.close();
        } catch (FileNotFoundException e) {
            System.err.print(e.getMessage());
        }
        
    }
}
