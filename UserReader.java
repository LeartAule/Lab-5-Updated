import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;



/**
 * Класс, который нужен для работы с пользователем.
 * Читает команды, введенные пользователем, из консоли.
 *
 */



public class UserReader extends Information{

    private static Scanner scanner = new Scanner(System.in);
    private Command commandReader = new Command();
    private static String str;



    public static String read(){
        return scanner.nextLine();
    }

   public void AskContinue() throws IOException {
        setBufferedReader();
       if(getNewXml().exists()){
           if (!(getBufferedReader().readLine() == null)) while (true) {
               System.out.println("Хотите продолжить свои предыдущие действия? {yes/no} {да/нет}");
               str = scanner.nextLine();
               if ((str.equals("Yes")) || (str.equals("да")) || (str.equals("Да")) || (str.equals("yes"))) {
                   Files.copy(getNewXml().toPath(), new FileOutputStream(getXml()));
                   setBufferedWriter();
                   getBufferedWriter().write("");
                   getBufferedWriter().flush();
                   break;
               } else if ((str.equals("No")) || (str.equals("no")) || (str.equals("Нет")) || (str.equals("нет"))) {
                   setBufferedWriter();
                   getBufferedWriter().write("");
                   getBufferedWriter().flush();
                   break;
               }
           }
       }else{
           getNewXml().createNewFile();
       }
       getBufferedReader().close();
       if(!(new File("newXml.xml").exists())){
           File file = new File("newXml.xml");
           file.createNewFile();
           setNewXml(file);
       }
   }

public void startConsole() {
    System.out.println("Выберите команду. (Список команд: введите help)");
    while (true) {
        str = scanner.nextLine();
        SortCollection();
        try {
            if (str.equals("exit")) {
                commandReader.commands("exit");
                break;
            }

            commandReader.commands(str);

            setScriptCounter(0);
        } catch (TransformerException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException ignored) {
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("(\uFEFF ͡° ͜ʖ ͡°) / Вы ввели неправильно.");
        }
    }
    }
}




