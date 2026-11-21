package ru.makerov.geometry;

public class Circle extends Figure{
    private Point center;
    private double radius;
    public Circle(Point center, double radius){
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double getArea(){
        return 3.14 * radius * radius;
    }

}
