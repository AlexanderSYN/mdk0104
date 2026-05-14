package com.zelmex.priorityrace;

import static com.zelmex.priorityrace.IO.perr;
import static com.zelmex.priorityrace.IO.println;

class HighThread implements Runnable {
    private volatile boolean running = true;
    private long startTime, endTime;
    public static long time;

    Thread highPriorityThread;

    int score = 0;

    public HighThread(int p) {
        highPriorityThread = new Thread(this);
        highPriorityThread.setName("HighPriorityThread");
        highPriorityThread.setPriority(p);
    }

    public void run() {
        startTime = System.currentTimeMillis();
        println("Поток " + highPriorityThread.getName() + " запущен (приоритет: " + highPriorityThread.getPriority() + ") ");

        for (int i = 0; i < 1000; i++) {
            score++;
            try {
                Thread.sleep(1);
            }
            catch (InterruptedException ie) {
                perr("Поток HighThreadPriority Прерван из-за ошибки");
            }
        }
        endTime = System.currentTimeMillis();
    }

    public void stop() {
        running = false;
        println();
        println("Поток HighPriorityThread завершил. Счётчик = " + score + ", Приоритет = " + highPriorityThread.getPriority());
        time = endTime - startTime;
        println("Время выполнения HighPriorityThread: " + time + " мс");
        println();
    }

    public void start() {
        highPriorityThread.start();
    }

}
