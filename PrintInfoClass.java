/**
 * Класс для вывода информации о коллекции
 */

public class PrintInfoClass extends Information {

    protected  void printInfo(){
        System.out.println("Тип коллекции: " + dragonLinkedHashMap.getClass().getSimpleName());
        System.out.println("Дата инициализации: " + dragonLinkedHashMap.values().toString());
        System.out.println("Количество элементов: " + dragonLinkedHashMap.size());
    }
}
