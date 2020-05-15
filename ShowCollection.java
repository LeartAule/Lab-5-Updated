import Dragon.Dragon;
import java.io.IOException;
import java.util.Map;

public class ShowCollection extends Information{

    protected static void showCollection() throws IOException, ArrayIndexOutOfBoundsException{
        if(!dragonLinkedHashMap.isEmpty()){
            for(Map.Entry<Integer, Dragon> entry : dragonLinkedHashMap.entrySet()) {
                System.out.println(entry.getValue().toDragonString());
                //System.out.println(entry.getKey());
            }
        }else{
            System.out.println("Коллекция пуста");
        }
    }




}
