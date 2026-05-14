package com.zelmex.priorityrace;

import static com.zelmex.priorityrace.IO.*;

class LowThread implements Runnable {
    private volatile boolean running = true;
    private long startTime, endTime;
    public static long time;
    Thread lowPriorityThread;

    int score = 0;

    public LowThread(int p) {
        lowPriorityThread = new Thread(this);
        lowPriorityThread.setName("LowPriorityThread");
        lowPriorityThread.setPriority(p);
    }

    public void run() {
        startTime = System.currentTimeMillis();
        println("Поток " + lowPriorityThread.getName() + " запущен (приоритет: " + lowPriorityThread.getPriority() + ") ");

        for (int i = 0; i < 1000; i++, score++) {
            try {
                Thread.sleep(1);
            }
            catch (InterruptedException ie) {
                perr("Поток LowThreadPriority Прерван из-за ошибки");
            }
        }
        endTime = System.currentTimeMillis();
    }

    public void stop() {
        running = false;
        println();
        println("Поток LowPriorityThread завершил. Счётчик = " + score + ", Приоритет = " + lowPriorityThread.getPriority());
        long time = endTime - startTime;
        println("Время выполнения LowPriorityThread: " + time + " мс");
        println();
    }

    public void start() {
        lowPriorityThread.start();
    }

}
