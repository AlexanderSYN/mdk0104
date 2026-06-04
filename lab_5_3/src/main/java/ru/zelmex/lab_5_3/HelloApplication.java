package ru.zelmex.lab_5_3;

public class HelloApplication {
    static final String[] arr = {"Array (Массив)", "List (Список)"};

    public static void main(String[] args) {
        ThreadLists tl1 = new ThreadLists(arr, "Thread-1");
        ThreadLists tl2 = new ThreadLists(arr, "Thread-2");
        ThreadLists tl3 = new ThreadLists(arr, "Thread-3");

        Thread t1 = new Thread(tl1);
        Thread t2 = new Thread(tl2);
        Thread t3 = new Thread(tl3);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException ie) {
            System.err.println("Interrupted Thread");
        }

        System.out.println("... (потоки работают параллельно) ...");
        System.out.println("===============================");
        System.out.printf("|| ВСЕГО ВЫВЕДЕНО СТРУКТУР: %d||\n", ThreadLists.total.get());
        System.out.printf("|| (3 * %d структур)          ||\n", arr.length);
        System.out.println("===============================");
        System.out.println("Программа завершена успешно!");
    }
}