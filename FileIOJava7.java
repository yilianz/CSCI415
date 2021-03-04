// nio package
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileIOJava7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		try {
			long starttime = System.nanoTime();

			Path inFilePath = Paths.get("test.pdf");  // current directory
    
			// read file into byte arrays (all in memory!!)
			byte[] buffer = Files.readAllBytes(inFilePath);   // read bytes to a buffer
			
			// In your case,  OutToClient.write(buffer,0,..)
			
			// write file 
            Path outFilePath = Paths.get("cp4.pdf");
			Files.write(outFilePath, buffer);
		
	
			long endtime = System.nanoTime();
			System.out.println("The time for byte by byte transfer is "
					+ (endtime - starttime));

		} catch (InvalidPathException e) {
			System.err.println( e.getMessage());
		} 
	}

}
