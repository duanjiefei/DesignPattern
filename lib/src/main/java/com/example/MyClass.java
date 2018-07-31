package com.example;


public class MyClass {
        public static void main(String[] args){
            System.out.println("hello java");
/*            Locktest locktest = new Locktest();
            System.out.println(locktest.testlock());*/
            MyThread myThread = new MyThread();
            new Thread(myThread).start();
            new Thread(myThread).start();
            new Thread(myThread).start();
        }

}
