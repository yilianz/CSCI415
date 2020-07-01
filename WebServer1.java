
/**
 * ***
 **
 ** USCA ACSC415 *
 */
import java.io.*;
import java.net.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class WebServer1 {

    public static void main(String argv[]) throws Exception {

        // Create Server Socket
        ServerSocket welcomeSocket = new ServerSocket(6789);

        // Create Server Socket
        try {
            while (true) {

                // create client socket, blocking if no incoming request.
                Socket connectionSocket = welcomeSocket.accept();

                // input stream  
                Scanner inFromClient = new Scanner(connectionSocket.getInputStream());

                //ouput stream
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

                //Get the message from client 
                String clientSentence = inFromClient.nextLine();

                //Tokenize this line, check whether it is a valid request.
                String[] temp = clientSentence.split(" ");
                System.out.println("From Client:" + clientSentence);
                //create the http response message if the request is valid
                // serverSentence ="HTTP/1.1 200 OK\r\n\r\n<!DOCTYPE html> <html><head><title>Dummy Website</title></head><body>Welcome to my dummy website"+"Could not find your file"+temp[1]+"</body></html>";
                // outToClient.writeBytes(serverSentence);

                //copy file --- try to copy an pdf file
                if (!temp[1].equalsIgnoreCase("/favicon.ico")) {
                    try {

                        Path inFilePath = Paths.get("." + temp[1]);

                        // read file into byte arrays (all in memory!!)
                        byte[] buffer = Files.readAllBytes(inFilePath);
                        int filesize = buffer.length;
                        System.out.println("Open file " + temp[1] + " file size" + filesize);
                        String contenttype = "text/html";
                        if (temp[1].endsWith(".jpg")) {
                            contenttype = "image/jpeg";
                        } else if (temp[1].endsWith(".pdf")) {
                            contenttype = "application/pdf";
                        }
                        String serverSentence = "HTTP/1.1 200 OK\r\nContent-Type:" + contenttype + "\r\nContent-Length:" + filesize + "\r\nConnection: close\r\n\r\n";
                        outToClient.writeBytes(serverSentence);
                        System.out.println(serverSentence);
                        outToClient.write(buffer, 0, filesize);

                        outToClient.flush();

                        System.out.println("Done file reading and writing done");
                    } catch (IOException e) {
                        System.out.println("Could not Open File");
                        String serverSentence = "HTTP/1.1 404 Not Found\r\nConnection: close\r\n\r\n<!DOCTYPE html> <html><head><title>File Not Found</title></head><body>Could not find your file" + temp[1] + "</body></html>";
                        outToClient.writeBytes(serverSentence);
                    }
                }
                // close stream and socket
                inFromClient.close();
                outToClient.close();
                connectionSocket.close();

            }
        } catch (Exception e) {
            System.err.println("Caught Exception " + e.getMessage());
        }
    }
}
