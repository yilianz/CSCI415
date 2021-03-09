
/**
 * ***
 ** A test of datagram ** 
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class simpleUDPClient {

    public static void main(String[] args) {

        try {

            // get a UDP socket
            DatagramSocket s = new DatagramSocket();  //bind to any port


            // construct a packet
            String hellomessage = "Hello, this is from yilian";  	// fixed message

	    // Read a message from keyboard?	

            //convert string to byte array
            byte[] buf = hellomessage.getBytes();
            InetAddress address = InetAddress.getByName("172.17.137.160");  // get the ip address of the host.

            //construct datagram packet
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 1327);
            
            

            // send a packet
            s.send(packet);


            //close the datagram socket
            s.close();


        } catch (IOException e) {

            System.err.print(e.getMessage());

        }
    }
}
