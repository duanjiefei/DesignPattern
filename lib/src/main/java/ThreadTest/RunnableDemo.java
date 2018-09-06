package ThreadTest;

public class RunnableDemo implements Runnable {

    private String threadName;
    private Thread mThread;
    public RunnableDemo(String threadName) {
        System.out.println("create thread"+threadName);
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("thread running"+threadName);
        try {
            for (int i = 4;i>0;i--){
                Thread.sleep(5000);
                System.out.println("thread name =="+ threadName+"i=="+i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("thread name =="+ threadName+"interrupted");
        }
        System.out.println("thread name =="+ threadName+"exiting");
    }

    public void start(){
        System.out.println("thread name =="+ threadName+"starting");
        if (mThread == null){
            mThread  = new Thread(this,threadName);
        }
        mThread.start();
    }
}
