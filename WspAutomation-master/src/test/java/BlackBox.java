import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BlackBox {
    public static void CallBack(String PhoneNum, String Status){
        //Obtener la fecha y hora.
        DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss z");
        String date = dateFormat.format(new Date());
        //Grabando el mensaje
        try(FileWriter fw = new FileWriter("CallBack.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(Status+": El mensaje al número "+PhoneNum+" , En la fecha: "+date);
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }
}
