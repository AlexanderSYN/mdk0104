package ru.zelmex.lab_5_3;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLists implements Runnable {
    final Thread t;
    final String[] arr;
    static AtomicInteger total = new AtomicInteger(0);
    public ThreadLists(String[] arr, String name) {
        t = new Thread(this);
        t.setName(name);
        this.arr = arr;
    }

    @Override
    public void run() {
        try {
            System.out.println("=== Поток " + t.getName() + " начинает вывод ===");
            for (int i = 0; i < arr.length; i++) {
                System.out.println(t.getName() + ": " + (i + 1) + "." + arr[i]);
                Thread.sleep(400);
                total.incrementAndGet();
            }
            System.out.println("=== Поток " + t.getName() + " завершил работу ===");
        } catch (InterruptedException ie) {
            System.err.println("Thread interrupted");
        }
    }
}
