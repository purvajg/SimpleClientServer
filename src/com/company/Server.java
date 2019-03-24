package com.company;

import lombok.Data;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

@Data
public class Server {
    Integer port;


    ServerSocket serverSocket;

    Server(Integer port) throws IOException {
        this.port = port;
        serverSocket = new ServerSocket(port);
    }

    public Socket listen() throws IOException {
        System.out.println("Server socket listening on " +port);
        return serverSocket.accept();
    }

    public void process() throws IOException {
        Socket socket = listen();
        Scanner in = new Scanner(socket.getInputStream());
        while(in.hasNext()) {
            System.out.println(in.nextLine());
        }
    }

}
