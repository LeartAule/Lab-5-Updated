import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;

/**
 * Класс для сохранения коллекции в файл
 */

public class SaveClass extends Information {

    public void SaveCollection() throws IOException {
        try {

            Writter.write(getDragonLinkedHashMap(),getXml());
           BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter(getNewXml()));
           bufferedWriter1.write("");
            bufferedWriter1.flush();
           bufferedWriter1.close();
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }

    }
}
