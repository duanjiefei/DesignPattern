package threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {


    public static void main(String[] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,//核心线程数的大小，当线程数大于核心线程时，提交的任务会被提交进缓存队列
                20,//最大线程数的大小
                5000,//线程能够存活的时间
                TimeUnit.MILLISECONDS,//线程存活时间的单位毫秒
                new ArrayBlockingQueue<Runnable>(5)
                );
        for (int i=0;i<25;i++){
            MyThread myThread = new MyThread(i);
            executor.execute(myThread);
            System.out.println("CorePoolSize()=="+executor.getCorePoolSize()+"PoolSize()=="+executor.getPoolSize()+"getQueue().size()"+executor.getQueue().size());
        }
        executor.shutdown();
    }



    static class MyThread extends Thread{

        private int threadNum;

        public MyThread(int threadNum) {
            this.threadNum = threadNum;
        }

        @Override
        public void run() {
            try {
                System.out.println("start   "+threadNum+"   thread");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
            System.out.println(threadNum+"  start   "+"end");
        }
    }
}
