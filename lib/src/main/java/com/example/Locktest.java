package com.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Sky000 on 2018/5/28.
 */

public class Locktest {
    int i = 0;
    Lock lock = new ReentrantLock();
    public int testlock(){
        lock.lock();
        try {
            i = i + 1;
        }finally {
            lock.unlock();
        }
        return i;
    }
}
