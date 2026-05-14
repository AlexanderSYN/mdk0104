package com.zelmex.priorityrace;

import static com.zelmex.priorityrace.IO.*;

public class HelloApplication {
    public static void main(String[] args) {
        long timeDifference;

        println("=== Запуск программы PriorityRace ===");

        HighThread highThread = new HighThread(Thread.MAX_PRIORITY);
        LowThread lowThread = new LowThread(Thread.MIN_PRIORITY);

        highThread.start();
        lowThread.start();

        try {
            highThread.highPriorityThread.join();
            lowThread.lowPriorityThread.join();
        }
        catch (InterruptedException ie) {
            perr("Thread Interrupted");
        }

        highThread.stop();
        lowThread.stop();

        println("=== Результаты соревнования ===");
        if (HighThread.time > LowThread.time) {
            timeDifference = HighThread.time - LowThread.time;
            println("Поток HighPriorityThread завершил работу ПЕРВЫМ!");
            println("Разница по времени: " + timeDifference + "мс");
        }
        else {
            timeDifference = LowThread.time - HighThread.time;
            println("Поток LowPriorityThread завершил работу ПЕРВЫМ!");
            println("Разница по времени: " + timeDifference + "мс");
        }

    }
}

