
/**
 * ***
 **
 ** USCA ACSC415 *
 */
import java.io.*;
import java.net.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

class WebServerHint{

    public static void main(String argv[]) throws Exception {
        String clientSentence = " ";
        String serverSentence = " ";
        ServerSocket welcomeSocket=null;

        // Create Server Socket
        try {
            welcomeSocket= new ServerSocket(80);

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
                //                if (temp[0]  .... )
                
                // You need to ignore the request for favicon.ico.
                //                if (temp[1].equals("/favicon.ico")) ...
                
                // Otherwise get the name of the file -- temp[1] and send the file requested by client
                // I will show an example which opens a pdf file.
                try{
                    Path inFilePath = Paths.get("testss.pdf");  // current directory
    
                    // read file into byte arrays (all in memory!!)
                    byte[] buffer = Files.readAllBytes(inFilePath);   // read bytes to a buffer

                     // construct the response message and send it to client
                    String statusline = "HTTP/1.1 200 OK\r\n";
                    String headlines1= "Content-Type: application/pdf\r\n";
                    String headlines2= "Content-Length:"+buffer.length+"\r\n\r\n";

                    // send the statusline and headlines 
                    outToClient.writeBytes(statusline+headlines1+headlines2);

                    // send the entity body  
                    outToClient.write(buffer,0,buffer.length);
                    outToClient.flush();

                }catch(InvalidPathException e) {
                    // send 404 request if the file is not found 
                    // more codes need to be added here. 


                    System.err.println( e.getMessage());
                }

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
