package socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server running at port 4444...");
        while (true) {
            Socket socket = serverSocket.accept();

            new SocketSoma(socket).soma();

        }
    }
}