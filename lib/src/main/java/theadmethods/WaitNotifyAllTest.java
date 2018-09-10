package theadmethods;

public class WaitNotifyAllTest {

    private static Object object = new Object();
    public static void main(String[] args){
    }


    static class MyThread extends Thread{

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
        }
    }
}
