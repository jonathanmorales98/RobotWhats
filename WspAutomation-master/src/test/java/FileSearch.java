import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileSearch implements ActionListener {
    public String Route;
    @Override
    public void actionPerformed(ActionEvent e) {
        Scanner entrada = null;
        JFileChooser fileChooser = new JFileChooser();
        FileFilter fil = new FileNameExtensionFilter("Archivos excel (.xlsx)", "xlsx");
        fileChooser.setFileFilter(fil);
        fileChooser.showOpenDialog(fileChooser);
        try {
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            File f = new File(ruta);
            entrada = new Scanner(f);
            Route = ruta;
            while (entrada.hasNext()) {
                System.out.println(entrada.nextLine());
            }
        } catch (FileNotFoundException i) {
            System.out.println(i.getMessage());
        } catch (NullPointerException i) {
            System.out.println("No se ha seleccionado ningún fichero");
        } catch (Exception i) {
            System.out.println(i.getMessage());
        } finally {
            if (entrada != null) {
                entrada.close();
                Gui.TextoSelector.setText(Route);
                try {
                    ReadExcel.ReadExcel(Route);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

    }
}
