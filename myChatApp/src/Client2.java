//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.Socket;
//
//public class Client2 {
//    public static void main(String[] args) throws Exception {
//        Socket s = new Socket("localHost",8008);
//
//        while(true) {
//            InputStreamReader ir = new InputStreamReader(s.getInputStream());
//            BufferedReader br = new BufferedReader(ir);
//
//            String str = br.readLine();
//        }
//    }
//
//}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws Exception {

        while (true) {
            Socket s = new Socket("localHost", 8008);
            //Socket s = new Socket("192.168.0.107", 8008);//rohan's ip address
            System.out.println("connected to server");
            OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
            //PrintWriter ps = new PrintWriter(os);

            while(true) {
                Scanner keyBoard = new Scanner(System.in);
                System.out.println("Client2: ");
                String message = keyBoard.nextLine();

                os.write(message + "\n");
                os.flush();
                System.out.println("Waiting for Client's reply");
                if (message.equals("exit")) break;

                InputStreamReader isr = new InputStreamReader(s.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                String replyFromClient = br.readLine();

                System.out.println("Client: " + replyFromClient);
                if (replyFromClient.equalsIgnoreCase("exit")) {
                    System.out.println("Server stopped the communication" + "\n" + "now closing ");
                    break;
                }
            }
            break;
        }
    }
}

