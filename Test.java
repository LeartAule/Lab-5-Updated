import java.io.*;
import java.util.*;
import Dragon.*;


/**
 *Работа с коллекциями
 *
 * @author  Kirill Kondrashov
 *          Group: P3111
 *
 */


public class Test {
    private static final LinkedHashMap<Integer, Dragon> dragonLinkedHashMap = new LinkedHashMap<Integer, Dragon>();
    private static UserReader userReader = new UserReader();
    private static FileReaderXml fileReaderXml = new FileReaderXml();

    public static void main(String[] args) throws IOException {


        userReader.setXml(new File(args[0]));// Принимает аргумент командноц строки
        userReader.AskContinue();//Спрашивает пользователя на продолжение программы, которая была прервана
        fileReaderXml.ReadDragonFile();//Чтение коллекции из файла
        userReader.startConsole();//Запуск программы
        Information.stop();//Конец программы


        System.out.println("Завершение программы.");
    }
}
