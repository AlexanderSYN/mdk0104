package ru.zelmex.demo1alex;

public class ThreadColor implements Runnable {

    private final Thread t;
    private final String[] colors;

    public ThreadColor(String[] colors, String name) {
        t = new Thread(this);
        t.setName(name);
        this.colors = colors;
    }

    public void run() {
        System.out.println(t.getName() + " начал работу");
        try {
            for (int i = 0; i < colors.length; i++) {
                System.out.println((i + 1) + "." + colors[i]);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ie) {
            System.err.println("Interrupted Thread");
        }
        System.out.println();
    }

}