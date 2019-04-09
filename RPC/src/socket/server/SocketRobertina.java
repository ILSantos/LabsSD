package socket.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketRobertina {

    private final Socket socket;

    public SocketRobertina(Socket socket) {
        this.socket = socket;
    }

    public void robertina() throws IOException {
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        float q0 = in.readInt();
        float qf = in.readInt();
        int t = in.readInt();

        float div = qf / q0;
        int raiz = (int) Math.pow(div, t);
        float i = raiz - 1;

        out.writeFloat(i);
        System.out.println("Taxa de juros mensal calculada!");
        in.close();
        out.close();
        socket.close();
    }
}
