import Dragon.*;
import static Dragon.ColorText.Text;


/**
 *
 * Класс, который выводит список существующих команд
 */

public class PrintHelpClass extends Command{


        protected void printHelp(){
            System.out.println(Text("info", Color.YELLOW) +": вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
            System.out.println(Text("show", Color.YELLOW) +": вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
            System.out.println(Text("insert {key}", Color.YELLOW) +": добавить новый элемент с заданным ключом");
            System.out.println(Text("update_id {key}", Color.YELLOW) +": обновить значение элемента коллекции, id которого равен заданному");
            System.out.println(Text("remove_key {key}", Color.YELLOW) +": удалить элемент из коллекции по его ключу");
            System.out.println(Text("clear", Color.YELLOW) +": очистить коллекцию");
            System.out.println(Text("save", Color.YELLOW) +": сохранить коллекцию в файл");
            System.out.println(Text("execute_script {file_name}", Color.YELLOW) +": считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
            System.out.println(Text("exit", Color.YELLOW) +": завершить программу (без сохранения в файл)");
            System.out.println(Text("remove_greater {element}", Color.YELLOW) +": удалить из коллекции все элементы, превышающие заданный");
            System.out.println(Text("remove_lower {element}", Color.YELLOW) +": удалить из коллекции все элементы, меньшие, чем заданный");
            System.out.println(Text("remove_lower_key {key}", Color.YELLOW) +": заменить значение по ключу, если новое значение больше старого");

            System.out.println(Text("min_by_name", Color.YELLOW) +": Вывести объект, минимального по имени.");
            System.out.println(Text("print_field_descending_type", Color.YELLOW) +": Вывести коллекцию, сортируя по типу.");
            System.out.println(Text("print_field_descending_character", Color.YELLOW) +": Вывести коллекцию, сортируя по character.");

        }


}
