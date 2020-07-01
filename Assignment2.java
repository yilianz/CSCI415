
/**
 * ***
 **
 ** USCA CSCI415 *
 */
import java.io.*;
import java.net.*;
import java.util.*;

class Assignment2{

public static void main(String argv[]) throws Exception {
        String clientSentence = " ";
        String serverSentence = " ";

        // Create Server Socket
        try {
            ServerSocket welcomeSocket = new ServerSocket(80);

            while (true) {
                // create client socket, blocking if no incoming request.
                Socket connectionSocket = welcomeSocket.accept();
                System.out.println("Accept connection from" + connectionSocket.getRemoteSocketAddress());


                // input stream
                Scanner inFromClient = new Scanner(connectionSocket.getInputStream());

                // ouput stream
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                
                
                String fromClient = inFromClient.nextLine();
                System.out.println("From Client: " + fromClient);
                
                String requestType = fromClient.split(" ")[0];
                
                String header="";
                String content="";
                if(!requestType.equals("GET")) {
                		header = "HTTP/1.1 400 BAD REQUEST\\r\\n";
                }
                else {
                     header = "HTTP/1.1 200 OK\r\nContent-type: text/html\r\n\r\n ";
                    
                     content = "<html>"
                    		+ "<head></head>"
                    		+ "<body>"
                    		+ "<h1>HELLOOOOOOOOOO</h1>"
                    		+ "<label>What is your name?</label><br>"
                    		+ "<input id='name' type='text' placeholder='your name'>"
                    		+ "<button id='enter' >ENTER</button>"
                    		+"<script>"
                    		+ "document.getElementById('enter').onclick=function(){"
                    		+ "var name = document.getElementById('name').value; "
                    		+ "alert('Hello, ' + name.toUpperCase() +'!');"
                    		+ "};"
                    		+ "</script>"
                    		+ "</body>"
                    		+ "</html>";
              
                }
                System.out.println("Respond: " + header);
                outToClient.writeBytes(header + content);
                // get the message from client
              
              /*  clientSentence = inFromClient.nextLine();
                System.out.println( + clientSentence);
            
                // construct the response message and send it to client
                serverSentence =  clientSentence.toUpperCase();  //change to uppercase 
                outToClient.writeBytes(serverSentence);
*/

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
