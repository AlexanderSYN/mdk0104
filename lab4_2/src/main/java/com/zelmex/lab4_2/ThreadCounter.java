package com.zelmex.lab4_2;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Float.sum;
import static java.lang.Math.abs;
import static com.zelmex.lab4_2.IO.*;

public class ThreadCounter implements Runnable {
    private long startTime, time;
    static AtomicInteger sharedCounter = new AtomicInteger(0);
    public Thread t;
    int count = 0;

    public ThreadCounter(String name) {
        t = new Thread(this);
        t.setName(name);
    }

    public void setPriority(int priority) {
        t.setPriority(priority);
    }

    public void run() {
        count = 0;
        try {
            startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < 5000) {
                count++;
                sharedCounter.incrementAndGet();
                Thread.sleep(10);
            }
        }
        catch (InterruptedException ie) {
            perr("Поток " + t.getName() + " остановлен!\n" +
                    "Ошибка: " + ie.getMessage());
        }

    }

    public void start() {
        t.start();
    }

    public void printInfo() {
        println("Поток " + t.getName() + ": личных итерации = " + count +
                ", приоритет = " + t.getPriority());

    }
}
