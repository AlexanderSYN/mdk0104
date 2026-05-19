package com.zelmex.lab4_2;

import static com.zelmex.lab4_2.IO.*;
import static com.zelmex.lab4_2.ThreadCounter.sharedCounter;
import static java.lang.Thread.*;

class MainApp {
    static ThreadCounter FastCounter = new ThreadCounter("FastCounter");
    static ThreadCounter NormalCounter = new ThreadCounter("NormalCounter");
    static ThreadCounter SlowCounter = new ThreadCounter("SlowCounter");

    public static void main(String[] args) {
        FastCounter.setPriority(MAX_PRIORITY);
        NormalCounter.setPriority(NORM_PRIORITY);
        SlowCounter.setPriority(MIN_PRIORITY);

        println("Запуск потоков...");

        FastCounter.start();
        NormalCounter.start();
        SlowCounter.start();

        try {
            FastCounter.t.join();
            NormalCounter.t.join();
            SlowCounter.t.join();
        }
        catch (InterruptedException ie) {
            perr("Не удалось сделать потоки дочерними");
        }

        FastCounter.printInfo();
        NormalCounter.printInfo();
        SlowCounter.printInfo();

        println("Общий счётчик: " + sharedCounter.get());

        int total = FastCounter.count +
                    NormalCounter.count +
                    SlowCounter.count;
        println("Сумма личных счётчиков: " + total);
        println("Победитель: " + getWinner());
    }

    public static String getWinner() {
        ThreadCounter winner = FastCounter;

        if (NormalCounter.count > winner.count)
            return "NormalCounter (выполнил больше всего итераций)";

        else if (SlowCounter.count > winner.count)
            return "SlowCounter (выполнил больше всего итераций)";

        return "FastCounter (выполнил больше всего итераций)";

    }
}