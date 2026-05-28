package com.zelmex.labsix;

import java.io.IOException;


public class Main  {
    private static final Object lock = new Object();
    private static String currentColor = "Red";
    private static int count = 0;

    public static void main(String[] args) {
        Thread red = new Thread(new Light("Red", "Yellow"), "RedLight");
        Thread yellow = new Thread(new Light("Yellow", "Green"), "YellowLight");
        Thread green = new Thread(new Light("Green", "Red"), "GreenLight");

        red.start();
        yellow.start();
        green.start();

        try {
            red.join();
            yellow.join();
            green.join();
        } catch (InterruptedException ie) {
            System.err.println("Error thread: " + ie.getMessage());
        }

        System.out.println("Светофор завершил работу. Всего переключений " + count);
    }

    static class Light implements Runnable {
        private String color;
        private String nextColor;

        Light(String color, String nextColor) {
            this.color = color;
            this.nextColor = nextColor;
        }

        public void run() {
            for (int i = 1; i <= 4; i++) {
                synchronized (lock) {
                    while (!currentColor.equals(color)) {
                        try {
                            lock.wait();
                        }
                        catch (InterruptedException ie) {
                            return;
                        }
                    }
                    count++;
                    System.out.printf("[%s] горит [%d] раз\n", currentColor, i);

                    if (currentColor.equals("Green"))
                        System.out.println();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {
                        return;
                    }

                    currentColor = nextColor;
                    lock.notifyAll();
                }
            }
        }
    }
}