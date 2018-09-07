package reentrantlock;

import java.util.Calendar;
import java.util.concurrent.locks.ReentrantLock;

//测试锁的公平性与非公平性
public class TestLock2 {

    public static void main(String[] args){
        final MyService myService = new MyService(false);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                myService.printTime();
                System.out.println(Thread.currentThread().getName()+"running");
            }
        };

        Thread[] threads = new Thread[10];
        for (int i=0;i<10;i++){
            threads[i] = new Thread(runnable);
            threads[i].start();
        }



    }


    static class MyService {
        private ReentrantLock lock = null;

        public MyService(boolean isFaire) {
            lock  = new ReentrantLock(isFaire);
        }

        private void printTime(){
            try {
                lock.lock();
                Calendar calendar  =Calendar.getInstance();
                System.out.println("getlock"+"Thread name == "+Thread.currentThread().getName()+"Time =="+calendar.getTime());
            } finally {
                lock.unlock();
                System.out.println("unlock"+"Thread name == "+Thread.currentThread().getName()+"Time =="+Calendar.getInstance().getTime());
            }
        }
    }
}
