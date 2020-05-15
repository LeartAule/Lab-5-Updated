import Dragon.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс, исполняющий команды.
 *
 */


class Command extends Information{
    private static UserReader userReader = new UserReader();



    public void commands(String command) throws IOException, NumberFormatException, TransformerException, ParserConfigurationException {
        String[] line = command.split(" ");
        boolean bool = true;
        int kek = 0;
        switch (line[0]){
            case "exit":
                new ExitClass().Exit();
                break;
            case "Lenny":
                System.out.println("(\uFEFF ͡° ͜ʖ ͡°)");
                break;
            case "help":
                new PrintHelpClass().printHelp();
                break;
            case "info":
                new PrintInfoClass().printInfo();
                break;
            case "show":
                ShowCollection.showCollection();
                break;
            case "insert":
                CollectionCommandsClass.Add(Integer.parseInt(line[1]));
                ReserveSave();
                break;

            case "update_id":
                CollectionCommandsClass.Update(Integer.parseInt(line[1]));
                ReserveSave();
                break;

            case"clear":
                clear();
                ReserveSave();
                break;

            case"save":
                new SaveClass().SaveCollection();
                getNewXml().delete();
                System.out.println("Коллекция сохранена в файл " + getXml());
                break;

            case "execute_script" :
                if(getScriptCounter() < 10){
                    System.out.println("Для избежания зацикливания. Команда execute_script временно не доступна.");
                    break;
                }
                Scanner scanner1;
                try {
                    FileReader fileReader = new FileReader(line[1]);
                    scanner1 = new Scanner(fileReader);
                } catch (FileNotFoundException e) {
                    System.out.println("Файл не найден");
                    break;
                }
                incCounter();
                readAndExecute(scanner1);
                break;

            case"remove_key":
                int key = Integer.parseInt(line[1]);
                CollectionCommandsClass.Remove(key);
                ReserveSave();
                break;

            case "remove_greater":
                if(dragonLinkedHashMap.isEmpty()){
                    System.out.println("Коллекция пуста");
                    break;
                }
                CollectionCommandsClass.removeGreater();
                System.out.println("Все значения больше заданного удалены.");
                ReserveSave();
                break;

            case"remove_lower":
                if(dragonLinkedHashMap.isEmpty()){
                    System.out.println("Коллекция пуста");
                    break;
                }
                CollectionCommandsClass.removeLower();
                System.out.println("Все значения меньше заданного удалены");
                ReserveSave();
                break;

            case"remove_lower_key":
                if(dragonLinkedHashMap.isEmpty()){
                    System.out.println("Коллекция пуста");
                    break;
                }
                int rlk = Integer.parseInt(line[1]);
                System.out.println("Были удалены: ");
                for(Map.Entry<Integer, Dragon> dragonEntry : dragonLinkedHashMap.entrySet()){
                    if(dragonEntry.getKey() > rlk){
                        dragonLinkedHashMap.remove(rlk);
                        System.out.print(rlk + " ");
                    }
                }
                ReserveSave();

            case"min_by_name":
                if(dragonLinkedHashMap.isEmpty()){
                    System.out.println("Коллекция пуста");
                    break;
                }
                CollectionCommandsClass.minName();
                break;

            case"print_field_descending_type":
                if(dragonLinkedHashMap.isEmpty()){
                    System.out.println("Коллекция пуста");
                    break;
                }
                CollectionCommandsClass.field_descending_type();
                break;

            case"print_field_descending_character":
                if(dragonLinkedHashMap.isEmpty()){
                    System.out.println("Коллекция пуста");
                    break;
                }
                CollectionCommandsClass.field_descending_character();
                break;

            case " ":
                break;

            case"insert_test":
                int l = (int)(Math.random()*1000);
                int count = 0;
                while(true){
                    count++;
                    if(count > 100){break;}
                    for (Map.Entry<Integer, Dragon> dragonEntry : dragonLinkedHashMap.entrySet()) {
                        if (!dragonEntry.getKey().equals(l)) {
                            l = (int)(Math.random()*1000);
                            break;
                        }
                    }}
                dragonLinkedHashMap.put(l, creation());
                Writter.write(dragonLinkedHashMap,getNewXml());
                break;

            case "":
                kek++;
                if(kek % 10 == 0){
                    System.out.println("¯\\_(Э Э)_/¯ ");}
                break;

            default:
                System.out.println("Такая команда не поддерживается.");
                break;
        }

    }

    private static void clear() {
        String str;
            System.out.println("Вы уверены что хотите удалить коллекцию?");
            System.out.println("Для ответа введите да/нет, yes/no");
            str = userReader.read();
            if((str.equals("да")) || (str.equals("Да")) ||(str.equals("Yes")) ||(str.equals("yes")) ||(str.equals("da")) ) {
                Dragon dragon = new Dragon();
                dragon.setGlobalId(0);
                dragonLinkedHashMap.clear();
                System.out.println("Коллекция была удалена.");
            }else{
                if(str.equals("no")||str.equals("нет")){System.out.println("отмена");}else{
                    System.out.println("Все равно отмена");
                }
            }
    }

    private void readAndExecute(Scanner scanner) throws IOException, TransformerException, ParserConfigurationException, NoSuchElementException {
        String str;
        try {
            while ((str = scanner.nextLine()) != null) {
                System.out.println(ColorText.Text(str, Color.BLUE));
                commands(str);
            }
        }catch (NoSuchElementException e){}
    }

    private static Dragon creation () {
        Dragon dragon = new Dragon();
        dragon.setGlobalId(dragon.getGlobalId() - 1);
        dragon.prim_update(dragon.getGlobalId());
        System.out.println("Дракон " + dragon.getName() + " был добавлен.");
        return dragon;
    }


    private static void ReserveSave() throws TransformerException, ParserConfigurationException {
        Writter.write(getDragonLinkedHashMap(), getNewXml());
    }
}
