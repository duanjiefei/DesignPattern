package booleantest;

public class BooleanTest {
    static boolean boolValue;
    public static void main(String[] args){
        boolValue = true;
        if (boolValue) System.out.println("hello java ");
        if (boolValue == true) System.out.println("hello jvm ");
    }
}
