import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;

class ExitClass extends Command{

   void Exit() throws ParserConfigurationException, TransformerException, IOException {
       BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(new FileInputStream(getNewXml())));
       String str1 = bufferedReader1.readLine();
       if(getNewXml().exists() && !(str1 == null)){
           System.out.println("Есть несохранный данные. Вы хотите их сохранить? {yes/no} {да/нет}");
           String str = UserReader.read();
           if(str.equals("дa") || str.equals("yes")){
               commands("save");
           }else{
               BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter(getNewXml()));
               bufferedWriter1.write("");
               bufferedWriter1.close();
           }
       }
       bufferedReader1.close();
    }
}
