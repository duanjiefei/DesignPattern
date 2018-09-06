package reentrantlock;

import java.util.Calendar;
import java.util.concurrent.locks.ReentrantLock;


//测试可重入锁的可重入特性
public class TestLock1 {

    private ReentrantLock lock = null;
   // private Lock lock1 = null;

    public TestLock1() {
        lock = new ReentrantLock();
    }

    public static void main(String[] args){
        TestLock1 testLock1 = new TestLock1();
        try {
            testLock1.printTime();//第一次获取锁，所并没有释放
            testLock1.printTime();//再次拿到锁，并打印时间，说明锁可重入
            testLock1.printTime();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            testLock1.getLock().unlock();
            testLock1.getLock().unlock();
            testLock1.getLock().unlock();//依次去释放锁
        }
    }

    private ReentrantLock getLock(){
        return lock;
    }

    private void printTime(){
        lock.lock();
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime().toString()+ "  "+ Thread.currentThread().getName()+"get lock");
    }
}
