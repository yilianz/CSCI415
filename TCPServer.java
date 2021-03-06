
/**
 * ***
 **
 ** USCA ACSC415 *
 */
import java.io.*;
import java.net.*;
import java.util.*;

class TCPServer {

    public static void main(String argv[]) throws Exception {
        String clientSentence = " ";
        String serverSentence = " ";
        ServerSocket welcomeSocket=null;

        // Create Server Socket
        try {
            welcomeSocket= new ServerSocket(1234);

            while (true) {
                // create client socket, blocking if no incoming request.
                Socket connectionSocket = welcomeSocket.accept();
                System.out.println("Accept connection from" + connectionSocket.getRemoteSocketAddress());

                // input stream
                Scanner inFromClient = new Scanner(connectionSocket.getInputStream());
 
                // ouput stream
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

                // get the message from client 
                // HTTP Request   -----   GET /main.html HTTP/1.1              
                clientSentence =inFromClient.nextLine();
                System.out.println("From Client:" + clientSentence);

                //Tokenize this line, check whether it is a valid request.
                String[] temp = clientSentence.split(" ");
                System.out.println("Http Request Method:" + temp[0]);
                System.out.println("File path: "+ temp[1]);
                
                // Get the file if the request is valid
                // You need ignore the request for favicon.ico. 

                // construct the response message and send it to client
               // requestline = "HTTP/1.1 200 OK\r\n";
              //  headlines1= "Content-Type: text/html\r\n"
              //  headlines2= "Content-Length: .....\r\n"
              //  endheadline ="\r\n"
                // Read file and put the file as body
             //   body ="<html><head><title>YHBT.net</title></head><body>HAND</body></html>"; //clientSentence.toUpperCase();  //change to uppercase 
                outToClient.writeBytes(serverSentence);


                // close stream and socket
                inFromClient.close();
                outToClient.close();
                connectionSocket.close();

            }
        }catch (IOException e) {
            System.err.println("Caught Exception " + e.getMessage());
        }finally{
            if (welcomeSocket !=null ) welcomeSocket.close();  // no need in java 7 above
        }

    }
}
