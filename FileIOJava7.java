// nio package
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileIOJava7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// target copy file
		try {
			long starttime = System.nanoTime();

			Path inFilePath = Paths.get("test.pdf");
    
			// read file into byte arrays (all in memory!!)
			byte[] buffer = Files.readAllBytes(inFilePath);
			
			// write file 
                        Path outFilePath = Paths.get("cp3.pdf");
			Files.write(outFilePath, buffer);
		
	
			long endtime = System.nanoTime();
			System.out.println("The time for byte by byte transfer is "
					+ (endtime - starttime));

		} catch (IOException e) {
			System.err.println( e.getMessage());
		} 
	}

}
