import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {
    static XSSFWorkbook newWorkbook;
    public static void ReadExcel(String ruta) throws IOException {
        File file = new File(ruta);
        FileInputStream inputStream = new FileInputStream(file);
        newWorkbook = new XSSFWorkbook(inputStream);
        int Hojas = newWorkbook.getNumberOfSheets();
        System.out.println(newWorkbook);
        for (int i = 0; i < Hojas; i++) {
            System.out.println(newWorkbook.getSheetName(i));
            Gui.Selector.addItem(newWorkbook.getSheetName(i));
        }

    }

}