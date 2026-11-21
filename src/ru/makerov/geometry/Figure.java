package ru.makerov.geometry;

public abstract class Figure {
    public abstract double getArea();

    public static double getTotalArea(Figure[] figures) {
        double total = 0;

        for (Figure figure : figures) {
            total += figure.getArea();
        }

        return total;
    }
}
