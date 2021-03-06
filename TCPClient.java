
/**
 * ***
 **
 ** USCA CSCI415 *
 */
import java.io.*;
import java.net.*;
import java.util.*;

class TCPClient {

    public static void main(String argv[]) throws Exception {

        // InputStream from the Keyboard using Scanner
        Scanner inFromUser = new Scanner(System.in);

        // Create a socket which connect to Server (HOSTNAME, PORTNUM)
        String Hostname = "www.httpvshttps.com"; // try www.httpvshttps.com
        int Port = 80;                      // try 80
        Socket clientSocket=null;
        
        try {
            clientSocket = new Socket(Hostname, Port);
            //InputStream from the Server -- Note scanner can not handle binary data
            Scanner inFromServer = new Scanner(clientSocket.getInputStream());

            //OutputStream to the Server ---DataOutputStream Class is used to handle binary data
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            
            //Read data from the user and sent it over the internet
            String sentence = "GET / HTTP/1.1\r\nHost: www.httpvshttps.com\r\n\r\n";//inFromUser.nextLine() + "\r\n";
            //System.out.println("From Client: " + sentence);
            outToServer.writeBytes(sentence);

            //Read response from the server and display it on screen
            String modifiedSentence = inFromServer.nextLine();
            System.out.println("FROM SERVER: " + modifiedSentence);
            while(inFromServer.hasNext()){
                modifiedSentence = inFromServer.nextLine();
            System.out.println("FROM SERVER: " + modifiedSentence);
            }
            

            // Close the connection
            clientSocket.close();
            inFromUser.close();
            inFromServer.close();
            

        } catch (IOException e) {
            System.err.print("Caught Exception" + e.getMessage());
        } finally{
            if (clientSocket !=null ) clientSocket.close();  // no need in java 7 above
        }
        
    }
}
