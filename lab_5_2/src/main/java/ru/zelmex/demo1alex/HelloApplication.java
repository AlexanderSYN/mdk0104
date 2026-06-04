package ru.zelmex.demo1alex;

public class HelloApplication {
    final static String[] colors = {"Red (Красный)", "Orange (Оранжевый)", "Yellow (Желтый)", "Green (Зеленый)",
            "Blue (Синий)", "Indigo (Синий/Фиолетовый)", "Violet (Фиолетовый)"};

    public static void main(String[] args) {
        ThreadColor t1 = new ThreadColor(colors, "thread-1");
        ThreadColor t2 = new ThreadColor(colors, "thread-2");
        ThreadColor t3 = new ThreadColor(colors, "thread-3");
        ThreadColor t4 = new ThreadColor(colors, "thread-4");


        System.out.println("Список цветов (7 элементов)");
        t1.run();
        t2.run();
        t3.run();
        t4.run();

    }

}