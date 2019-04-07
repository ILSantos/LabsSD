package socket.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketClient {
    public int soma(int n1, int n2) throws IOException {
        Socket socket = new Socket("localhost", 4444);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());

        out.writeInt(n1);
        out.writeInt(n2);

        int soma = in.read();

        in.close();
        out.close();
        socket.close();

        return soma;
    }
}