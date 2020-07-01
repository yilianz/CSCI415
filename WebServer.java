
/**
 * ***
 **
 ** USCA ACSC415 *
 */
import java.io.*;
import java.net.*;
import java.util.*;

class WebServer {

	public static void main(String argv[]) throws Exception {
		String clientSentence = " ";
		String serverSentence = " ";

		ServerSocket welcomeSocket = null;

		// Create Server Socket
		try {

			// Try a server that accept four connections.
			welcomeSocket = new ServerSocket(80);
			for (int i = 0; i < 4; i++) {

				// create client socket, blocking if no incoming request.
				Socket connectionSocket = welcomeSocket.accept();

				// input stream //should use DataInputStream
				Scanner inFromClient = new Scanner(connectionSocket.getInputStream());

				// output stream
				DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

				// Get the message from client
				String request = inFromClient.nextLine();
				System.out.println(request);
				String temp[] = request.split(" ");
				System.out.println("The file path is " + temp[1]);

				// Construct response
				String response;
				//text
				if(request.endsWith(".txt")){
					if(inFromClient.nextLine() == null)
						response = "404 file not found";
					else
						response = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n<html><body><p>From W.com</p></body></html>";
				}
				//image
				else if(request.endsWith(".jpg")||request.endsWith(".jpeg")){
					if(inFromClient.nextLine() == null)
						response = "404 file not found";
					else
						response = "HTTP/1.1 200 OK\r\nContent-Type: image/jpeg\r\n\r\n<html><body><p>From W.com</p></body></html>";
				}
				else{
					response = "400 bad request response";
				}
				
				//Send response
				outToClient.writeBytes(response);

				// close stream and socket
				inFromClient.close();
				outToClient.close();
				connectionSocket.close();

			}
		} catch (IOException e) {
			System.err.println("Caught Exception " + e.getMessage());
		}

		if (welcomeSocket != null)
			welcomeSocket.close();
	}
}
