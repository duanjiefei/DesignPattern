package ListTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class ListTest {
    public static void main(String[] args){
        Vector vector = new Vector();  //java 早期提供的线程安全的arrayList vector 在扩容时会加一倍的的空间
        ArrayList arrayList = new ArrayList();  // 非线程安全的arraylist ,在扩容时会增加  capcity >> 1 ,即一半的空间
        LinkedList linkedList = new LinkedList();
    }
}
