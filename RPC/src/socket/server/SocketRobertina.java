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

        float q0 = in.readFloat();
        float qf = in.readFloat();
        float t = in.readInt();

        // TO DO: calculo da taxa de juros mensal 
        float div = qf / q0;
        float raiz = (float) Math.pow(div, t);
        float i = raiz - 1; 

        out.writeInt(i);
        System.out.println("Taxa de juros mensal calculada!");
        in.close();
        out.close();
        socket.close();
    }
}
