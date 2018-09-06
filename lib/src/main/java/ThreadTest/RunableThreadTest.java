package ThreadTest;

public class RunableThreadTest {
    public static void main(String[] args){
/*        RunnableDemo thread1 = new RunnableDemo("thread1");
        thread1.start();

        RunnableDemo thread2 = new RunnableDemo("thread2");
        thread2.run();*/

        ThreadDemo thread1 = new ThreadDemo("thread1");
        thread1.start();
        ThreadDemo thread2 = new ThreadDemo("thread2");
        thread2.start();
    }
}
