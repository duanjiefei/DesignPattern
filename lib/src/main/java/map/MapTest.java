package map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MapTest {
    private static Hashtable<Integer,String> hashtable = null;
    private static HashMap<Integer,String> hashMap = null;
    private static TreeMap<Integer,String> treeMap = null;
    private static LinkedHashMap<Integer,String> linkedHashMap = null;

    public static void main(String[] args){
        hashtable = new Hashtable<>();
        hashMap = new HashMap<>();
        treeMap = new TreeMap<>();
        linkedHashMap = new LinkedHashMap<>();
    }
}
