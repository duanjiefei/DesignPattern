package Int;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 利用对象类型的计数器
 */
public class Counter {
    //利用AtomicLong  保证线程安全
    private final AtomicLong counter = new AtomicLong(0);
    public void increase(){
        counter.incrementAndGet();
    }
}
