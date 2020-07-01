
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

        // Create Server Socket
        try {
            ServerSocket welcomeSocket = new ServerSocket(1234);

            while (true) {
                // create client socket, blocking if no incoming request.
                Socket connectionSocket = welcomeSocket.accept();
                System.out.println("Accept connection from" + connectionSocket.getRemoteSocketAddress());


                // input stream
                Scanner inFromClient = new Scanner(connectionSocket.getInputStream());

                // ouput stream
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

                // get the message from client
              
                clientSentence = inFromClient.nextLine();
                System.out.println("From Client:" + clientSentence);
            
                // construct the response message and send it to client
                serverSentence =  clientSentence.toUpperCase();  //change to uppercase 
                outToClient.writeBytes(serverSentence);


                // close stream and socket
                inFromClient.close();
                outToClient.close();
                connectionSocket.close();

            }
        } catch (IOException e) {
            System.err.println("Caught Exception " + e.getMessage());
        }

    }
}
