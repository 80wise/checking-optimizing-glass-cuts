package com.company;

public class Segment {
    private Point firstPoint;
    private Point secondPoint;

    public Segment(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    public void exchangePoints() {
        Point temporaryPoint = firstPoint;
        firstPoint = secondPoint;
        secondPoint = temporaryPoint;
    }
}
