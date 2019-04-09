package socket.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class TestClient extends JFrame {

	private static final long serialVersionUID = 1L;

    public TestClient() {
        Container panel = getContentPane();
        final JTextField q0 = new JTextField(5);
        final JTextField qf = new JTextField(5);
        final JTextField t = new JTextField(5);
        JButton ok = new JButton("Calcular taxa!");
        final JTextArea area = new JTextArea(30, 30);

        panel.setLayout(new FlowLayout());
        panel.add(q0);
        panel.add(qf);
        panel.add(t);
        panel.add(ok);
        panel.add(area);

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String s1 = q0.getText();
                    String s2 = qf.getText();
                    String s3 = t.getText();

                    float robertina = new SocketClient().robertina(Float.parseFloat(s1), Float.parseFloat(s2), Float.parseFloat(s3));

                    area.append("Taxa de juros mensal: " + robertina);

                } catch (NumberFormatException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        TestClient frame  = new TestClient();
        frame.setSize(400,300);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
