package socket.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class TestClient extends JFrame {
    public TestClient() {
        Container panel = getContentPane();
        final JTextField n1 = new JTextField(5);
        final JTextField n2 = new JTextField(5);
        JButton ok = new JButton("SOMAR");
        final JTextArea area = new JTextArea(30, 30);

        panel.setLayout(new FlowLayout());
        panel.add(n1);
        panel.add(n2);
        panel.add(ok);
        panel.add(area);

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String s1 = n1.getText();
                    String s2 = n2.getText();

                    int soma = new ClientSocket().soma(Integer.parseInt(s1), Integer.parseInt(s2));

                    area.append("Soma (" + s1 + " + " + s2 + "): " + soma);

                } catch (NumberFormatException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        ClientTest frame  = new ClientTest();
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