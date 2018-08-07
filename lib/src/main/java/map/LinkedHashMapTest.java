package map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    public static void main(String[] args){
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<String, String>(16,0.75F,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size()>5;
            }
        };
        linkedHashMap.put("1","one");
        linkedHashMap.put("2","two");
        linkedHashMap.put("3","three");
        linkedHashMap.put("4","four");
        linkedHashMap.put("5","five");
        for (Map.Entry<String ,String> entry :linkedHashMap.entrySet() ){
            System.out.println(entry.getKey()+">>"+entry.getValue());
        }

        linkedHashMap.get("2");
        //linkedHashMap.get("1");
        Iterator<Map.Entry<String,String>> iterator = linkedHashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> entry  = iterator.next();
            System.out.println(entry.getKey()+".."+entry.getValue());
        }

        linkedHashMap.put("6","six");
    }
}
