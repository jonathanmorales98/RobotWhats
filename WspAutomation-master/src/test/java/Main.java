import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Gui window = new Gui();
        window.setSize(600, 250);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //window.setBounds(400,200,600, 250);
        window.setTitle("Aplicación de mensajes automáticos a WhatsApp");
    }
}
