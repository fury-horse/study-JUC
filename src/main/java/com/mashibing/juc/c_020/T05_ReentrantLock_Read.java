package com.mashibing.juc.c_020;


import com.mashibing.U;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
* @desc    ¶ÁÐ´Ëø
* @version 1.0
* @author  Liang Jun
* @date    2020Äê05ÔÂ07ÈÕ 12:49:39
**/
public class T05_ReentrantLock_Read {
    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

        new Thread(()-> {
            readLock.lock();
            System.out.println("read locked : " + Thread.currentThread().getName());

            U.sleep(2000);
            readLock.unlock();
            System.out.println("read unlock : " + Thread.currentThread().getName());
        }).start();

        new Thread(()-> {
            readLock.lock();
            System.out.println("read locked : " + Thread.currentThread().getName());

            readLock.unlock();
            System.out.println("read unlock : " + Thread.currentThread().getName());
        }).start();
    }
}