

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame{
    private JPanel WindowPanel;
    static JTextField TextoSelector;
    private JLabel LabelSelector;
    private JLabel LabelTitulo;
    private JButton BotonSeleccionarArchivo;
    private JLabel LabelSheet;
    private JLabel LabelRun;
    private JButton BotonRun;

    static JComboBox<String> Selector;

    public Gui(){
        WindowPanel = new JPanel();
        LabelTitulo = new JLabel("Bienvenido a la apilcación de mensajes automáticos de Elimcoop.");
        LabelSelector = new JLabel("1. Selecciona la ruta del documento de excel que contiene la información:");
        TextoSelector = new JTextField(30);
        BotonSeleccionarArchivo = new JButton("Seleccionar archivo");
        LabelSheet = new JLabel("                       2. Selecciona la hoja de excel que se usará:                       ");
        LabelRun = new JLabel("                     3. Podras ejecutar el programa con el siguiente botón:                 ");
        BotonRun = new JButton("Iniciar el programa");
        Selector = new JComboBox<String>();
        FlowLayout layout = new FlowLayout();

        this.add(WindowPanel);
        //WindowPanel.setLayout(new GridLayout(7,1,5,10));
        //WindowPanel.setLayout(new BorderLayout());
        WindowPanel.setLayout(layout);
        layout.setHgap(20);
        WindowPanel.add(LabelTitulo);
        WindowPanel.add(LabelSelector);
        WindowPanel.add(TextoSelector);
        TextoSelector.setEnabled(false);
        WindowPanel.add(BotonSeleccionarArchivo);
        WindowPanel.add(LabelSheet);
        WindowPanel.add(Selector);
        Selector.addItem("Seleccione Hoja de Excel");
        WindowPanel.add(LabelRun);
        WindowPanel.add(BotonRun);

        BotonSeleccionarArchivo.addActionListener(new FileSearch());
        BotonRun.addActionListener(new whatsApp());
        Selector.addItemListener(new SelectedSheet());
    }
}
