import Dragon.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 *
 * Класс в котором храниться информация о коллекции и файлы для её записи
 *
 *
 */


abstract public class Information implements ColorText {

    protected static LinkedHashMap<Integer, Dragon> dragonLinkedHashMap = new LinkedHashMap<Integer, Dragon>();


    public static LinkedHashMap<Integer, Dragon> getDragonLinkedHashMap() {
        return dragonLinkedHashMap;
    }

    protected static File getXml() {
        return xml;
    }

    protected static void setXml(File xml) {
        Information.xml = xml;
    }

    protected static File getNewXml() {
        return newXml;
    }

    protected static void setNewXml(File newXml) {
        Information.newXml = newXml;
    }

    static private File xml = null;
    static private File newXml = new File("newXml.xml");
    static private int ScriptCounter = 0;


    protected static BufferedReader bufferedReader;
    protected static BufferedWriter bufferedWriter;

    protected static BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    protected static BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }

    public static void stop() throws IOException {
        try {
            getBufferedWriter().close();
            getBufferedReader().close();
        }catch (NullPointerException e){}
        getNewXml().delete();
    }

    protected static void setBufferedReader() {
        if(!getNewXml().exists()){
            try {
                getNewXml().createNewFile();
            } catch (IOException e) { e.printStackTrace(); }
        }
        {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(getNewXml())));
            } catch (FileNotFoundException e) { e.printStackTrace(); }
        }
    }

    protected static void setBufferedWriter() throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(getNewXml()));
    }



    protected int getScriptCounter() {
        return ScriptCounter;
    }

    protected void setScriptCounter(int scriptCounter) {
        ScriptCounter = scriptCounter;
    }

    protected void incCounter() {
        ScriptCounter++;
    }

//Сортирует коллецию по Id Дракона
    protected static void SortCollection() {

        Comparator<Integer> integerComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer s, Integer t1) {
                return s.compareTo(t1);
            }
        };
        List<Integer> integers = new ArrayList<>();
        for (Map.Entry<Integer, Dragon> dragonEntry : dragonLinkedHashMap.entrySet()) {
            integers.add(dragonEntry.getValue().getId());
        }
        LinkedHashMap<Integer, Dragon> linkedHashMap = new LinkedHashMap<Integer, Dragon>();
        Collections.sort(integers, integerComparator);
        for (Integer integer : integers) {
            linkedHashMap.put(integer, dragonLinkedHashMap.get(integer));
        }
        dragonLinkedHashMap = linkedHashMap;

    }



}