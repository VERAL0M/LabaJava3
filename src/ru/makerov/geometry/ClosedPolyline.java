package ru.makerov.geometry;

public class ClosedPolyline extends Polyline {
    public ClosedPolyline(Point... points) {
        super(points);
    }

    @Override
    public double getLength() {
        if (points.size() < 2) {
            return 0;
        }

        return super.getLength()
                + distance(points.get(points.size() - 1), points.get(0));
    }
}