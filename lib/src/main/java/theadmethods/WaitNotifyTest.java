package theadmethods;

public class WaitNotifyTest {


    public static void main(String[] args){

        MyThread myThread = new MyThread("A");
        synchronized (myThread){
            System.out.println("thread=="+Thread.currentThread().getName()+"is running");
            myThread.start();

            try {
                myThread.wait(3000);//该方法会使当前线程处于阻塞状态
                System.out.println("thread=="+Thread.currentThread().getName()+"is blocking");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("thread=="+Thread.currentThread().getName()+"is blocking");

            System.out.println("thread=="+Thread.currentThread().getName()+"is running again");

        }

    }

    static class MyThread extends Thread{

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (this){
                System.out.println("Thread == "+ Thread.currentThread().getName()+"call notify");
               // while (true);
                //notify();//会唤醒处于阻塞状态，处于等待当前锁对象的线程
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
