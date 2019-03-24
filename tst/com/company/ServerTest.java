package com.company;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.assertEquals;

public class ServerTest {

  private static Integer PORT = 8001;

  @Test
  public void listen() throws IOException {
    Server server = new Server(PORT);
    ServerSocket serverSocket = Mockito.mock(ServerSocket.class);
    //server.setServerSocket(serverSocket);

    Socket socket = Mockito.mock(Socket.class);

    Mockito.when(serverSocket.accept()).thenReturn(socket);

    Socket realSocket = server.listen();

    assertEquals(socket, realSocket);

  }

  @Test
  public void process() {
  }
}