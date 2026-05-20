package com.zelmex.messages;

public class IO {

    public static void print(String text) {
        System.out.print(text);
    }

    public static void println() {
        System.out.println();
    }

    public static void println(Object text) {
        System.out.println(text);
    }

    public static void perr(Object text) {
        System.err.println(text);
    }

    public static void printf(String text, Object... args) {
        System.out.printf(text, args);
    }
}