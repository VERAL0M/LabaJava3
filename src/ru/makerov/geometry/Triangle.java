package ru.makerov.geometry;

public class Triangle extends Figure {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private double distance(Point p1, Point p2) {
        double dx = p1.getX() - p2.getX();
        double dy = p1.getY() - p2.getY();

        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public double getArea() {
        double sideA = distance(b, c);
        double sideB = distance(a, c);
        double sideC = distance(a, b);

        double p = (sideA + sideB + sideC) / 2;

        return Math.sqrt(p * (p - sideA)
                * (p - sideB) * (p - sideC));
    }
}