/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 FITT.Ltd. All rights reserved.                         *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.test;

import java.util.concurrent.TimeUnit;

/**
 * <p>@description TODO </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-12-21
 */
public class ThreadTest implements Runnable {
    static int i = 0;

    public void increase() {
        i++;
    }

    @Override
    public void run() {
        try {
            for (int j = 0; j < 1000; j++) {
                increase();
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        Thread t3 = new Thread(test);
        Thread t4 = new Thread(test);
        Thread t5 = new Thread(test);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        System.out.println("i=" + i);
    }
}
