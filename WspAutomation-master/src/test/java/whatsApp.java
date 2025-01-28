import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class whatsApp extends SelectedSheet implements ActionListener {

    final String URL = "https://web.whatsapp.com/";
    final String PATH = "send/?phone=57";

    final int SECONDS = 7;
    final int FACTOR = 3;

    //Elements
    String xpathCodeQR = "//canvas[contains(@aria-label,'Scan me!')]";
    String classMessage = "_ak1l";

    public void whatsApp() throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to(URL);
        driver.manage().timeouts().implicitlyWait(SECONDS*FACTOR, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        Thread.sleep(20000);
        /*new WebDriverWait(driver, Duration.ofSeconds(SECONDS*FACTOR))
                .until(ExpectedConditions.invisibilityOfElementLocated
                        (By.xpath(xpathCodeQR)));*/

        for(int i = 1 ; i <= RowCount; i++){

            XSSFRow row = newSheet.getRow(i);
            XSSFCell phone = row.getCell(0);
            XSSFCell msj = row.getCell(1);
            String Cel = String.valueOf(phone);
            Cel = Cel.replace(".", "").replace("E9", "");
            String Message = String.valueOf(msj);

            try {
            //driver.navigate().to(URL+PATH+Cel);
            System.out.println("paso 0");
            WebElement consult = driver.findElement(By.xpath("(//span[contains(.,'new-chat-outline')])[2]"));
            System.out.println("paso 1");
            consult.click();
            System.out.println("paso 2");
            WebElement search = driver.findElement(By.xpath("(//p[contains(@class,'selectable-text copyable-text')])[1]"));
            search.sendKeys("+57"+Cel);
            System.out.println("paso 3");
            Thread.sleep(2000);
            search.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            System.out.println("paso 4");
            WebElement message = driver.findElement(By.xpath("(//p[contains(@class,'selectable-text copyable-text')])[2]"));
            message.click();
            message.sendKeys(Message);
            Thread.sleep(2000);
            message.sendKeys(Keys.ENTER);
            message.sendKeys(Keys.ESCAPE);
            System.out.println(Message);
            System.out.println("paso 5");
            Thread.sleep(2000);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            BlackBox.CallBack(Cel,"EXITOSO");
            System.out.println("correcto");
            }
            catch (Exception ex){

                BlackBox.CallBack(Cel,"FALLIDO");
                System.out.println("falló");
                //driver.navigate().to(URL);
                Thread.sleep(2000);
            }
            System.out.println("paso 6");
            //driver.navigate().refresh();
        }
        driver.quit();
    }

    private boolean isElementPresent(ChromeDriver driver, By by){
        try{
            driver.findElement(by);
            return true;
        }
        catch (Exception ex){
            return false;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e){
        try {
            whatsApp();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
