package thradlocal;

public class ThreadLocalTest {

    private ThreadLocal<String> local = new ThreadLocal<>();
    private void setLocal(String threadname){
        local.set(threadname);
    }

    private String getLocal(){
        return local.get();
    }
    public static void main(String[] args){
        final ThreadLocalTest test = new ThreadLocalTest();
        test.setLocal(Thread.currentThread().getName());
        System.out.println(test.getLocal());  //获取主线程的threadlocal 保存的变量

        Thread myThread = new Thread(){
            @Override
            public void run() {
                test.setLocal(Thread.currentThread().getName());//获取子线程的 threadlocal保存的本地变量
                System.out.println(test.getLocal());
            }
        };

        try {
            myThread.start();
            myThread.join(); //保证子线程结束后才执行主线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(test.getLocal());  //再次获取主线程的threadlocal 保存的变量
    }
}
