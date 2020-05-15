import Dragon.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.*;
import java.util.List;


/**
 *
 * Класс для работы с коллекцией
 */


class CollectionCommandsClass extends Command{


/////////////Создания ссылки на нового дракона
    private static Dragon insert(Integer id) throws IOException {
        Dragon dragon = new Dragon();
        dragon.setGlobalId(dragon.getGlobalId() - 1);
        dragon.update(id);
        System.out.println("Дракон " + ColorText.Text(dragon.getName(),dragon.getColor()) + " был добавлен.");
        return dragon;
    }
/////////////добавление ссылки нового дракона в коллекцию
    static void Add(Integer i) throws IOException{
        boolean bool = true;
        for (Map.Entry<Integer, Dragon> dragonEntry : dragonLinkedHashMap.entrySet()) {
            if (dragonEntry.getKey().equals(i)) {
                System.out.println("Элемент с таким ключом уже существует");
                bool = false;
            }
        }
        if (bool) {
            dragonLinkedHashMap.put(i, insert(i));
            try {
                Writter.write(dragonLinkedHashMap, getNewXml());
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (TransformerException e) {
                e.printStackTrace();
            }
        }
    }
////////////Замена полей одной существующей ссылки
    static void Update(Integer j) throws TransformerException, ParserConfigurationException, IOException {
        boolean bool = true;
        for (Map.Entry<Integer, Dragon> dragonEntry : dragonLinkedHashMap.entrySet()) {
            if (dragonEntry.getKey().equals(j)) {
                bool = false;
            }
        }
        if (!bool) {

            dragonLinkedHashMap.put(j, insert(j));
            Writter.write(dragonLinkedHashMap,getNewXml());
        }else{
            System.out.println("Элемента таким номером не существует.");
        }
    }
///////////////
    static void Remove(Integer key){
        boolean bool = false;
        for (Map.Entry<Integer, Dragon> dragonEntry : dragonLinkedHashMap.entrySet()) {
            if (!dragonEntry.getKey().equals(key)) {
                //System.out.println("Элемент с таким ключом не сущетсвует существует");
                bool = true;
            }
        }
        if(bool){
            System.out.println("Дракон " + ColorText.Text(dragonLinkedHashMap.get(key).getName(), dragonLinkedHashMap.get(key).getColor()) + " под номер " + key + " был удален.");
            dragonLinkedHashMap.remove(key);
        }else{
            System.out.println("Такого дракона не существует.");
        }
    }




    static void removeGreater() throws IOException {
        System.out.println("Введите данные Группы. Все группы, которые больше вашей(исходя из логики сравнения), будут удалены.");
        Dragon dragon = new Dragon();
        dragon.update(dragon.getGlobalId());
        dragonLinkedHashMap.entrySet().removeIf(entry -> entry.getValue().compareTo(dragon) < 0);
    }


    static void removeLower() throws IOException {
        System.out.println("Введите данные Группы. Все группы, которые меньше вашей(исходя из логики сравнения), будут удалены.");
        Dragon dragon = new Dragon();
        dragon.update(dragon.getGlobalId());
        dragonLinkedHashMap.entrySet().removeIf(entry -> entry.getValue().compareTo(dragon) > 0);
    }

    static void minName(){
        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return t1.compareTo(s);
            }
        };
        List<String> strings = new ArrayList<>();
        for (Map.Entry<Integer, Dragon> dragonEntry : dragonLinkedHashMap.entrySet()) {
            strings.add(dragonEntry.getValue().getName());
        }
        Collections.sort(strings, stringComparator);
        System.out.println("Вывод имен в порядке возрастания");
        for (String string : strings) {
            System.out.println(string);
        }
    }


    static void field_descending_type() {
        System.out.println("Типы в порядке возрастания");
        Comparator<DragonType> dragonTypeComparator = new Comparator<DragonType>() {
            public int compare(DragonType d1, DragonType d2) {
                return d1.compareTo(d2);
            }
        };
        List<DragonType> dragonTypes = new ArrayList<>();
        for (Map.Entry<Integer, Dragon> dragonEntry : dragonLinkedHashMap.entrySet()) {
            dragonTypes.add(dragonEntry.getValue().getType());
        }
        Collections.sort(dragonTypes, dragonTypeComparator);
        for (DragonType dragonType : dragonTypes) {
            System.out.println(dragonType);
        }
    }

    static void field_descending_character() {
        System.out.println("Character в порядке возрастания");
        Comparator<DragonCharacter> dragonCharacterComparator = new Comparator<DragonCharacter>() {
            public int compare(DragonCharacter d1, DragonCharacter d2) {
                return d1.compareTo(d2);
            }
        };
        List<DragonCharacter> dragonCharacters = new ArrayList<>();
        for (Map.Entry<Integer, Dragon> dragonEntry : dragonLinkedHashMap.entrySet()) {
            dragonCharacters.add(dragonEntry.getValue().getCharacter());
        }
        Collections.sort(dragonCharacters, dragonCharacterComparator);
        for (DragonCharacter dragonCharacter : dragonCharacters) {
            System.out.println(dragonCharacter);
        }
    }



}
