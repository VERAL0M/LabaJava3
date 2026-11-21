package ru.makerov.geometry;

public class Square extends Figure {
    private  Point topLeft;
    private  double side;

    public Square(Point topLeft, double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Сторона должна быть больше нуля");
        }
        this.topLeft = topLeft;
        this.side = side;
    }


    @Override
    public double getArea() {
        return side * side;
    }

    public Polyline getPolyline() {
        double x = topLeft.getX();
        double y = topLeft.getY();

        return new ClosedPolyline(
                new Point(x, y),
                new Point(x + side, y),
                new Point(x + side, y + side),
                new Point(x, y + side)
        );
    }
}