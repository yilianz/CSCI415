import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class chatprogram {
    public static void main(String[] args) {
        // one thread listen to the port and print the message received
        Runnable listenServer = () -> {
            // put your udp server code here
           
            try {
                // Create a datagram socket and bind to port 1327
               
                while (true) {

                    // receive a packet


                    // display response
                    
                }

            } catch (Exception e) {
                // TODO: handle exception
            }

        };

        new Thread(listenServer).start();

        // The main thread read message from keyboard and sent it to everyone
        // put your udp client code here
        try {

            DatagramSocket s =null;
            String hellomessage ="hi";
            while (!hellomessage.equalsIgnoreCase("quit")){

            // read a message from dialog box
            hellomessage = JOptionPane.showInputDialog("Please input your message?"); // fixed message

            // create a datagram socket 

            // convert string to byte array and construct the packet
            byte[] buf = hellomessage.getBytes();
            InetAddress address = InetAddress.getByName("......."); // get the ip address of the host.

            // construct datagram packet
            
            // send a packet
            
            

            // close the datagram socket
            s.close();

        } catch (IOException e) {

            System.err.print(e.getMessage());

        }

    }

}
