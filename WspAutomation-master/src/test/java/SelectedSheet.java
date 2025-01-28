import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SelectedSheet extends ReadExcel implements ItemListener {
    static String Sheet;
    static Integer RowCount;
    static XSSFSheet newSheet;

        public void SelectedSheet(){
            Sheet = (String) Gui.Selector.getSelectedItem();
            //System.out.println(Sheet);
            newSheet = newWorkbook.getSheet(Sheet);
            //System.out.println(newSheet);
            //System.out.println(newWorkbook);
            RowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();

            System.out.println("RowCount: "+RowCount);
        }

    @Override
    public void itemStateChanged(ItemEvent e) {
        SelectedSheet();
    }
}
