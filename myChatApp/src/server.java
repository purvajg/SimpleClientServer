import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss= new ServerSocket(8008);

        while(true) {
            System.out.println("Waiting for connection with client");
            Socket s = ss.accept();
            System.out.println("Connected");

            while (true) {
                InputStreamReader ir = new InputStreamReader(s.getInputStream());
                BufferedReader sc = new BufferedReader(ir);
                System.out.println("Waiting for message from client ");
                String str = sc.readLine();
                System.out.println("Client: " + str);

                if (str.equalsIgnoreCase("exit")) {
                    System.out.println("Client stopped the communication" + "\n" + "Now closing ");
                    break;
                }

                OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());

                Scanner serverSideKeyboard = new Scanner(System.in);
                System.out.println("Server: ");
                String reply = serverSideKeyboard.nextLine();

                os.write(reply + "\n");
                os.flush();
                if (reply.equals("exit")) break;
            }
            break;
        }
    }
}
