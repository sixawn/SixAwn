/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 FITT.Ltd. All rights reserved.                         *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>@description TODO </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-12-21
 */
public class RunRace {
    CountDownLatch stopLatch = new CountDownLatch(1);
    CountDownLatch runLatch = new CountDownLatch(10);

    public void waitSign() throws Exception {
        System.out.println("选手:" + Thread.currentThread().getName() + " 正在等待裁判发布口令");
        stopLatch.await();
        System.out.println("选手: " + Thread.currentThread().getName() + " 已接收裁判口令");
        Thread.sleep((long) (Math.random() * 10000));
        System.out.println("选手: " + Thread.currentThread().getName() + " 到达终点");
        runLatch.countDown();
    }

    public void waitStop() throws Exception {
        Thread.sleep((long) (Math.random() * 10000));
        System.out.println("裁判:" + Thread.currentThread().getName() + " 裁判即将发布口令");
        stopLatch.countDown();
        System.out.println("裁判: " + Thread.currentThread().getName() + " 已发送口令，正在等待所有选手到达终点");
        runLatch.await();
        System.out.println("所有选手到达终点");
        System.out.println("裁判: " + Thread.currentThread().getName() + " 汇总成绩排名");
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        RunRace runRace = new RunRace();
        for (int i = 0; i < 10; i++) {
            Runnable runnable = () -> {
                try {
                    runRace.waitSign();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
            executorService.execute(runnable);
        }
        try {
            runRace.waitStop();
        } catch (Exception e) {
            e.printStackTrace();
        }

        AtomIntegerTest atomIntegerTest = runRace.new AtomIntegerTest();
        Thread t1 = new Thread(atomIntegerTest);
        Thread t2 = new Thread(atomIntegerTest);
        t1.start();
        t2.start();


        CASLock casLock = runRace.new CASLock();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    casLock.tryLock();
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    casLock.unlock();
                }
            }).start();
        }

    }

    class AtomIntegerTest implements Runnable {
        AtomicInteger atomicInteger = new AtomicInteger(200);

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(atomicInteger.getAndDecrement());
            }
        }
    }

    class CASLock {
        AtomicInteger atomicInteger = new AtomicInteger();
        Thread currentThread = null;

        public void tryLock() throws Exception {
            boolean isLock = atomicInteger.compareAndSet(0, 1);
            if (!isLock) {
                throw new Exception("加锁失败");
            }
            currentThread = Thread.currentThread();
            System.out.println(currentThread + " tryLock");
        }

        public void unlock() {
            int lockValue = atomicInteger.get();
            if (0 == lockValue) {
                return;
            }
            if (currentThread == Thread.currentThread()) {
                atomicInteger.compareAndSet(1, 0);
                System.out.println(currentThread + " unlock");
            }
        }
    }

}
