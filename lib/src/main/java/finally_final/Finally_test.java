package finally_final;

import java.util.ArrayList;
import java.util.List;

public class Finally_test {
    public static void main(String[] args){
        try {
            System.out.println("do complete");
            System.exit(0);
        } finally {
            System.out.println("not complete");
        }
    }

    private void finalListTest(){
        final List<String>  list  = new ArrayList<>();
        list.add("hello ");
        list.add("java");
        //final List<String> finalList =
        //StringBuffer
    }
}
