import java.io.DataOutputStream;
import java.net.Socket;
import java.util.*;
public class Emailclient {
    public static void main(String[] args) {
        String host = "";
        int port = ;

        try {
            Socket mysocket = new Socket(host, port);
            Scanner Infrom = new Scanner(mysocket.getInputStream());
            DataOutputStream OutTo = new DataOutputStream(mysocket.getOutputStream());
            // read greeting message from the server
            String response = Infrom.nextLine();
            System.out.println("Server: " + response);
            if (!response.startsWith("220")) throw new Exception("220 reply not received from server.");

            // send HELO command
            String message = "HELO usca.edu \r\n";
            System.out.println("Client: " + message);
            OutTo.writeBytes(message);
            response = Infrom.nextLine();   
            System.out.println("Server: " + response);
            if (!response.startsWith("250")) throw new Exception("250 reply not received from server.");

            // close everything
            Infrom.close();
            OutTo.close();
            mysocket.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


    }
}
