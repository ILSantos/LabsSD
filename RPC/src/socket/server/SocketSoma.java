package socket.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketSoma {

    private final Socket socket;

    public SocketSoma(Socket socket) {
        this.socket = socket;
    }

    public void soma() throws IOException {
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        int n1 = in.readInt();
        int n2 = in.readInt();

        out.write(n1 + n2);
        System.out.println("Soma realizada!");
        in.close();
        out.close();
        socket.close();
    }
}
