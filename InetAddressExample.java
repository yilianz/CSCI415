
/**
 * @(#)InetAddressExample.java
 *
 *
 * @author
 * @version 1.00
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class InetAddressExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
     
            String hostname ="www.usca.edu";
            InetAddress serverAddr= InetAddress.getByName(hostname);
            System.out.println("Ip address of "+hostname+" is "+serverAddr.getHostAddress());
            byte[] addr= serverAddr.getAddress();
            addr[0] = 207-256;
            addr[1] = 144-256;
            addr[2] = 25;
            addr[3] = 22;
            System.out.println(addr[0]&0xFF);
            System.out.println(addr[1]&0xFF);
            System.out.println(addr[2]&0xFF);
            System.out.println(addr[3]&0xFF);
    
            InetAddress newAddr = InetAddress.getByAddress(addr);
            System.out.println("Ip address of "+newAddr.getHostName()+" is "+newAddr.getHostAddress());
            
            /*test on byte array
            String message = "hhhhh eeee oooo";
            byte[] marray=message.getBytes();
            for (int i = 0; i < marray.length; i++) {
                System.out.println(marray[i] & 0xFF);
            }
            */
            /* Name to IP address
            Scanner userInput = new Scanner(System.in);
            System.out.println("What is the host name?");
            String hostname = userInput.nextLine();
            InetAddress thisIP = InetAddress.getByName(hostname);
            System.out.println(thisIP);
            //System.out.println("IP address is  " + thisIP.getHostAddress());
             
            //IP address byte representation
            byte[] addr = thisIP.getAddress();
            for (int i = 0; i < addr.length; i++) {
                System.out.println(addr[i] & 0xFF);
            }

            // InetAddress by byte array
            addr[3] = 20;
            InetAddress otherIP = InetAddress.getByAddress(addr);
            System.out.println(otherIP.getHostAddress());
            */
            
        }catch (UnknownHostException e) {

            System.err.print(e.getMessage());

        }

    }
}
