package com.mashibing.juc.c_000;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class T02_HowToCreateThread {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyThread!");
        }
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRun!");
        }
    }

    static class MyCall implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("Hello, MyCall!");
            return "Hello, MyCall";
        }
    }

    public static void main(String[] args) throws Exception {
        new MyThread().start();
        new Thread(new MyRun()).start();

        new Thread(()->{
            System.out.println("Hello Lambda!");
        }).start();

        FutureTask task = new FutureTask(new MyCall());
        new Thread(task).start();
        System.out.println(task.get());
    }

}

//请你告诉我启动线程的三种方式 1：Thread 2: Runnable 3:Executors.newCachedThrad
