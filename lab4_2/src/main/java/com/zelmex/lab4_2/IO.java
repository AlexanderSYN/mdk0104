package com.zelmex.lab4_2;

public class IO {

    public static void print(String text) {
        System.out.print(text);
    }

    public static void println() {
        System.out.println();
    }

    public static void println(String text) {
        System.out.println(text);
    }

    public static void perr(String text) {
        System.err.println(text);
    }

    public static void printf(String text, Object... args) {
        System.out.printf(text, args);
    }
}