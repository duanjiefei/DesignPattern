package reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockRunnable  implements  Runnable{
    private ReentrantLock lock = new ReentrantLock();

    //当runnable中有锁时，多个线程启动后会依次执行，当一个线程执行结束后，另一个线程才能获得执行
    @Override
    public void run() {
        try {
            lock.lock();

            for (int i=0;i<3;i++){
                Thread.sleep(5000);
                System.out.println("thread name == "+Thread.currentThread()+"print i == "+i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
