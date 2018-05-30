package singleton;

/**
 * Created by Sky000 on 2018/5/29.
 *
 * 参考链接 https://blog.csdn.net/liguangzhenghi/article/details/8076361
 */

public class Singleton {

    private  static Singleton singletonA  = null;
    private static Singleton singletonB = null;
    //在jdk 1.5及之后的版本，关键字volatile可以保证对象的实例每次都从主内存去获取
    private  volatile static Singleton singletonC = null;

    private static Singleton singletonD = new Singleton();

    /**
     * 保证了每次从getInstance()都能返回一个且唯一的一个对象。
     * @return
     */
    public static Singleton getSingletonA(){
        if (singletonA == null){
            singletonA = new Singleton();
        }
        return singletonA;
    }

    /**
     * 能够适应多线程并发访问，
     *
     * 但是除了在第一次初始化时会调用构造方法外，其余时间只是返回对象的实例
     *
     * 返回对象这个操作耗时是很小的，绝大部分的耗时都用在synchronized修饰符的同步准备上，因此从性能上说很不划算
     * @return
     */
    public static synchronized Singleton getSingletonB(){
        if (singletonB == null){
            singletonB = new Singleton();
        }
        return singletonB;
    }

    /**
     * 这样可以保证除了第一次需要走进同步代码块，其余时间无需进入同步代码块，避免了B的问题
     *
     *
     *  singletonC = new Singleton();
     *  1 给singleton的实例分配内存空间
     *  2 初始化singleton的构造函数
     *  3 将singletonC  指向分配的内存空间（此时singletonC！=null）
     *
     *  真实的环境中存在 1>2>3  和 1>3>2的执行顺序，第二种会导致异常将singletonC ==null
     * @return
     */
    public static Singleton getSingletonC(){
        if (singletonC == null){
            synchronized (Singleton.class){
                if (singletonC ==  null){
                    singletonC = new Singleton();
                }
            }
        }
        return singletonC;
    }

    /**
     * 可以避免并发的问题，本身属于饿汉式，在类被加载后会被创建
     *
     * @return
     */
    public static Singleton getSingletonD(){
        return singletonD;
    }

    private static class SingletonHolder{
        static final Singleton singletonE = new Singleton();
    }

    /**
     * 懒汉式
     *
     * @return
     */
    public static Singleton getSingletonE(){
       return SingletonHolder.singletonE;
    }

    /**
     * 将构造函数私有化，避免通过new的方式构建对象
     */
    private Singleton(){

    }

}
