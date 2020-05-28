package com.mashibing;


/**
* @desc    
* @version 1.0
* @author  Liang Jun
* @date    2020年03月18日 17:28:05
**/
public class U {
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}