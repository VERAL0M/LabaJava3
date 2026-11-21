package ru.makerov.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polyline {
    protected List<Point> points;

    public Polyline(Point... points) {
        this.points = new ArrayList<>(Arrays.asList(points));
    }

    public void setLastPoint(Point point) {
        if (points.isEmpty()) {
            throw new IllegalStateException("В ломаной нет точек");
        }
        points.set(points.size() - 1, point);
    }

    public double getLength() {
        double length = 0;

        for (int i = 1; i < points.size(); i++) {
            length += distance(points.get(i - 1), points.get(i));
        }

        return length;
    }

    protected double distance(Point first, Point second) {
        double dx = first.getX() - second.getX();
        double dy = first.getY() - second.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}