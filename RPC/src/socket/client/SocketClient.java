package socket.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketClient {

    public int robertina(int q0, int qf, int t) throws IOException {
        
        Socket socket = new Socket("localhost", 4200);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());

        out.writeInt(q0);
        out.writeInt(qf);
        out.writeInt(t);

        int robertina = in.read();

        in.close();
        out.close();
        socket.close();

        return robertina;
    }

}