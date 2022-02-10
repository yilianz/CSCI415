import java.net.*;
import java.util.Scanner;
import java.io.*;


public class tcpclienttest {
    public static void main(String[] args) throws Exception {

        // Start a socket 
        //Socket myS = new Socket("localhost",4343);
        Socket myS = new Socket("www.neverssl.com",80);
        // Input Stream and Output Stream
        Scanner inStream = new Scanner(myS.getInputStream());

        PrintWriter outStream = new PrintWriter(myS.getOutputStream());

        // get a message and sent to server
        String  message = "GET / HTTP/1.1\r\nHost:www.neverssl.com\r\n\r\n";

        outStream.println(message);

        outStream.flush();

        // get the message from the server 

        //System.out.println(inStream.nextLine());
        while(inStream.hasNextLine()){
            System.out.println(inStream.nextLine());
        }

        // close everything
        inStream.close();
        outStream.close();
        myS.close();    
        
    }
    
}
