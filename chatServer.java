/*

 */

import java.io.*;
import java.net.*;
import java.util.*;

public class chatServer {

    public static void main(String argv[]) throws Exception {

        int PORT = 1103;
        try (ServerSocket s = new ServerSocket(PORT)) {

            //server never close
            while (true) {

                Socket c = s.accept();
                Scanner in = new Scanner(c.getInputStream());
                PrintWriter out = new PrintWriter(c.getOutputStream());
                //DataOutputStream out = new DataOutputStream(c.getOutputStream());
                Scanner inFromUser = new Scanner(System.in);

                /*    
                while(in.hasNext()){
                System.out.println(in.next());
                }
                */
                
                String message = "let's start chatting ..";
                System.out.print(message);
                while (!message.equalsIgnoreCase("Quit")) {
                    out.println(message);  // send to client
                    out.flush();
                    System.out.println("From Client> " + in.nextLine());
                    System.out.print("Your message>");
                    message = "From server>"+inFromUser.nextLine();
                    System.out.print("please wait....");
                }
                out.close();
                in.close();
                c.close();

            }

        } catch (IOException e) {
            System.err.println(e);
        }

    }

}
