package socket.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketClient {

    public float robertina(float q0, float qf, float t) throws IOException {
        
        Socket socket = new Socket("localhost", 4200);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        out.writeFloat(q0);
        out.writeFloat(qf);
        out.writeFloat(t);

        float robertina = in.read();

        in.close();
        out.close();
        socket.close();

        return robertina;
    }

}
