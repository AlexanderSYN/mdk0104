package com.zelmex.lab4_2;

import static com.zelmex.lab4_2.IO.*;
import static java.lang.Thread.*;

class MainApp {
    public static void main(String[] args) {
        ThreadCounter FastCounter = new ThreadCounter("FastCounter");
        ThreadCounter NormalCounter = new ThreadCounter("NormalCounter");
        ThreadCounter SlowCounter = new ThreadCounter("SlowCounter");

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

        FastCounter.stop();
        NormalCounter.stop();
        SlowCounter.stop();
    }
}