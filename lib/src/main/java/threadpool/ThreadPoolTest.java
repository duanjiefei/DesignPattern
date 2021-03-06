package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
        corePoolSize：核心池的大小，这个参数跟后面讲述的线程池的实现原理有非常大的关系。在创建了线程池后，默认情况下，线程池中并没有任何线程，而是等待有任务到来才创建线程去执行任务，除非调用了prestartAllCoreThreads()或者prestartCoreThread()方法，从这2个方法的名字就可以看出，是预创建线程的意思，即在没有任务到来之前就创建corePoolSize个线程或者一个线程。默认情况下，在创建了线程池后，线程池中的线程数为0，当有任务来之后，就会创建一个线程去执行任务，当线程池中的线程数目达到corePoolSize后，就会把到达的任务放到缓存队列当中；

        maximumPoolSize：线程池最大线程数，这个参数也是一个非常重要的参数，它表示在线程池中最多能创建多少个线程；

        keepAliveTime：表示线程没有任务执行时最多保持多久时间会终止。默认情况下，只有当线程池中的线程数大于corePoolSize时，keepAliveTime才会起作用，直到线程池中的线程数不大于corePoolSize，即当线程池中的线程数大于corePoolSize时，如果一个线程空闲的时间达到keepAliveTime，则会终止，直到线程池中的线程数不超过corePoolSize。但是如果调用了allowCoreThreadTimeOut(boolean)方法，在线程池中的线程数不大于corePoolSize时，keepAliveTime参数也会起作用，直到线程池中的线程数为0；

        unit：参数keepAliveTime的时间单位，有7种取值，在TimeUnit类中有7种静态属性：


        TimeUnit.DAYS;               //天
        TimeUnit.HOURS;             //小时
        TimeUnit.MINUTES;           //分钟
        TimeUnit.SECONDS;           //秒
        TimeUnit.MILLISECONDS;      //毫秒
        TimeUnit.MICROSECONDS;      //微妙
        TimeUnit.NANOSECONDS;       //纳秒
        复制代码
        workQueue：一个阻塞队列，用来存储等待执行的任务，这个参数的选择也很重要，会对线程池的运行过程产生重大影响，一般来说，这里的阻塞队列有以下几种选择：
        1）ArrayBlockingQueue：基于数组的先进先出队列，此队列创建时必须指定大小；

        2）LinkedBlockingQueue：基于链表的先进先出队列，如果创建时没有指定此队列大小，则默认为Integer.MAX_VALUE；

        3）synchronousQueue：这个队列比较特殊，它不会保存提交的任务，而是将直接新建一个线程来执行新来的任务。
        ArrayBlockingQueue和PriorityBlockingQueue使用较少，一般使用LinkedBlockingQueue和Synchronous。线程池的排队策略与BlockingQueue有关。

        threadFactory：线程工厂，主要用来创建线程；

        handler：表示当拒绝处理任务时的策略，有以下四种取值：

        ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
        ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
        ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
        ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务
*/

public class ThreadPoolTest {


    public static void main(String[] args){
/*        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,//核心线程数的大小，当线程数大于核心线程时，提交的任务会被提交进缓存队列
                20,//最大线程数的大小
                5000,//线程能够存活的时间
                TimeUnit.MILLISECONDS,//线程存活时间的单位毫秒
                new ArrayBlockingQueue<Runnable>(5)
                );*/

        //1 创建固定的线程池
        //        public static ExecutorService newFixedThreadPool(int nThreads) {
        //            return new ThreadPoolExecutor(nThreads, nThreads,
        //                    0L, TimeUnit.MILLISECONDS,
        //                    new LinkedBlockingQueue<Runnable>());
        //        }
        // 1 固定线程池的核心线程池大小和最大线程个数一致
        // 2 由于核心线程池的大小和最大线程池的大小一致，所以keepAliveTime的时间无效
        // 3 new LinkedBlockingQueue<Runnable>()  基于链表的先进先出队列，如果创建时没有指定大小，则默认为Integer.MAX_VALUE
        //ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(8);
/*        2、SingleThreadExecutor - 线程池大小固定为1，任务队列无界

        public static ExecutorService newSingleThreadExecutor() {
            return new FinalizableDelegatedExecutorService
                    (new ThreadPoolExecutor(1, 1,
                            0L, TimeUnit.MILLISECONDS,
                            new LinkedBlockingQueue<Runnable>()));
        }*/
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i=0;i<25;i++){
            MyThread myThread = new MyThread(i);
            executor.execute(myThread);
            //System.out.println("CorePoolSize()=="+executor.getCorePoolSize()+"PoolSize()=="+executor.getPoolSize()+"getQueue().size()"+executor.getQueue().size());
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


