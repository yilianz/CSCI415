
/**
 * ***
 **
 ** USCA CSCI415 *
 */
import java.io.*;
import java.net.*;


class portScan {

    public static void main(String argv[]) throws Exception {

        // Scan the remote server
        String Hostname = "fileshare.usca.edu";
        int[] Port={21,22,23,25,80,135,137,138,139,443,445,3333};


        for (int i = 0; i < Port.length; i++) {
            
            try (Socket clientSocket = new Socket(Hostname, Port[i])){
                
                System.out.println("TCP Port "+Port[i]+"  is open");
                // Close the connection
                clientSocket.close();

            } catch (IOException e) {
                System.out.println("TCP Port "+Port[i]+"  is closed");
            } 
        }
    }
}
