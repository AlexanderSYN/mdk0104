package com.zelmex.lab;

public class ThreadQuotes implements Runnable {
    public Thread t;
    public String[] quotes;

    public ThreadQuotes(String name, String[] quotes) {
        t = new Thread(this);
        t.setName(name);
        this.quotes = quotes;
    }

    public void run() {

       System.out.println("Поток: " + t.getName());
       try {
           for (int i = 0; i < quotes.length; i++) {
               System.out.println((i + 1) + "." + quotes[i]);
               Thread.sleep(1000);
           }
       } catch (InterruptedException ie) {
           System.err.println(t.getName() + " Interrupted");
       }
       System.out.println();

    }


}
