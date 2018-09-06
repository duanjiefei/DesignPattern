package reentrantlock;

public class MyRunnable implements Runnable {


    //当runnable 中没有锁时，多个线程启动后会互相争夺资源，随机获得执行
    @Override
    public void run() {
        for (int i=0;i<3;i++){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread name == "+Thread.currentThread()+"print i == "+i);
        }

    }
}
