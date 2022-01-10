
/**
 * ***
 ** A test of datagram ** 
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient {

    public static void main(String[] args) {

        try {

            // get a UDP socket
            DatagramSocket s = new DatagramSocket(); // bind to any port

            // InputStream from the Keyboard using Scanner
            Scanner inFromUser = new Scanner(System.in);
            System.out.println("Please type your username: ");
            String username = inFromUser.nextLine();
            String message = "Start Chat........ ";
            System.out.println(message);

            // construct a packet
            
            while (!message.equalsIgnoreCase("Quit")){

            // convert string to byte array
            message = username + ">" +message;
            byte[] buf = message.getBytes();
            InetAddress address = InetAddress.getByName("255.255.255.255"); // get the ip address of the host.

            // construct datagram packet
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 1327);

            // send a packet
            s.send(packet);

            message = inFromUser.nextLine();
            }

            // close the datagram socket
            s.close();

        } catch (IOException e) {

            System.err.print(e.getMessage());

        }
    }
}
