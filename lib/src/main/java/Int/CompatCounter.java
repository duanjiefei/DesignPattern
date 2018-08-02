package Int;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/**
 * 利用原始数据类型的计数器
 */
public class CompatCounter {
    private  volatile  long counter = 0;
    //AtomicLongFieldUpdater可以对指定"类的 'volatile long'类型的成员"进行原子更新。它是基于反射原理实现的
    private static final AtomicLongFieldUpdater<CompatCounter> updater =  AtomicLongFieldUpdater.newUpdater(CompatCounter.class,"counter");

    public void increase(){
        updater.incrementAndGet(this);
    }
}
