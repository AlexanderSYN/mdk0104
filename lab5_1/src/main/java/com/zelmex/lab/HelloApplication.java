package com.zelmex.lab;


public class HelloApplication {

    public static String[] quotes = {"\"Knowledge is power\" - Francis Bacon (Знание сила)",
            "\"Time is money\" - Benjamin Franklin (Время деньги)",
            "\"Practice makes perfect\" - Ancient Proverb (Практика ведёт к совершенству)",
            "\"Actions spead loader than words\" - Aesop (Деействия громче слов)",
            "\"The early bird catches the worm\" - John Heywood (Кто рано встаёт, тому бог подаёт)",
    };
    public static void main(String[] args) {

        ThreadQuotes t1 = new ThreadQuotes("Thread 1", quotes);
        ThreadQuotes t2 = new ThreadQuotes("Thread 2", quotes);
        ThreadQuotes t3 = new ThreadQuotes("Thread 3", quotes);

        t1.run();
        t2.run();
        t3.run();
    }
}