/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 FITT.Ltd. All rights reserved.                         *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.test;

import java.util.concurrent.CountDownLatch;

/**
 * <p>@description TODO </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-12-21
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatchTest test = new CountDownLatchTest();
        test.testSimple();
    }

    public void testSimple() {
        CountDownLatch latch = new CountDownLatch(5);

        Increment increment = new Increment(latch);
        Decrement decrement = new Decrement(latch);

        new Thread(increment).start();
        new Thread(decrement).start();


        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class Increment implements Runnable {
        CountDownLatch countDownLatch;

        public Increment(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                for (long i = countDownLatch.getCount(); i > 0; i--) {
                    Thread.sleep(1000);
                    System.out.println("countdown:" + System.currentTimeMillis());
                    this.countDownLatch.countDown();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class Decrement implements Runnable {
        CountDownLatch countDownLatch;

        public Decrement(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println("await");
                this.countDownLatch.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Waiter Released");
        }
    }
}
