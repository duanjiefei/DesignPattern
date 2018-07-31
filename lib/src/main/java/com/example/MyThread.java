package com.example;

/**
 * Created by Sky000 on 2018/5/28.
 */

public class MyThread  implements Runnable{
    private int ticket = 5;
    @Override
    public void run() {
        for (int i =0;i<10;i++){
            if (ticket>0){
                System.out.println("ticket =="+ticket--);
            }
        }
    }
}
