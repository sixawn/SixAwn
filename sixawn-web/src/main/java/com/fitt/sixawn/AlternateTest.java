/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 fitt.Ltd. All rights reserved.                         *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn;

import java.util.concurrent.locks.LockSupport;

/**
 * <p>@description 交替输出 </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-09-25
 */
public class AlternateTest {

    static Object obj = new Object();

    static char[] charArr1 = "123456789".toCharArray();
    static char[] charArr2 = "ABCDEFGHI".toCharArray();

    public static void main(String[] args) {
        lockSupport();
    }

    static Thread t1 = null;
    static Thread t2 = null;

    public static void lockSupport() {
        t1 = new Thread(() -> lockSupportT1(), "t1");
        t2 = new Thread(() -> lockSupportT2(), "t2");

        t1.start();
        t2.start();
    }

    private static void lockSupportT1() {
        for (char c : charArr1) {
            System.out.print(c);
            LockSupport.unpark(t2);
            LockSupport.park();
        }
    }

    private static void lockSupportT2() {
        for (char c : charArr2) {
            System.out.print(c);
            LockSupport.unpark(t2);
            LockSupport.park();
        }
    }


    public static void syncWaitNotify() {
        new Thread(() -> {
            for (char ch : charArr1) {
                synchronized (obj) {
                    System.out.print(ch);
                    obj.notify();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            obj.notify();
        }, "t1").start();

        new Thread(() -> {

            for (char ch : charArr2) {
                synchronized (obj) {
                    System.out.print(ch);
                    obj.notify();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            obj.notify();
        }, "t2").start();
    }
}
