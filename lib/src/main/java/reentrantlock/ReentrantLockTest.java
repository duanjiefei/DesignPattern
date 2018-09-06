package reentrantlock;

public class ReentrantLockTest {
    public static void main(String[] args){

/*        MyRunnable myRunnable1 = new MyRunnable();
        new Thread(myRunnable1,"a").start();
        new Thread(myRunnable1,"b").start();*/

   ReentrantLockRunnable myRunnable = new ReentrantLockRunnable();
        new Thread(myRunnable,"a").start();
        new Thread(myRunnable,"b").start();
    }
}
