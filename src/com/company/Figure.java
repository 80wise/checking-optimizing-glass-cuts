package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Figure {
    private HashSet<Point> points;
    private Segment firstSegment;
    private Segment secondSegment;
    private Segment thirdSegment;
    private Segment forthSegment;

    public Figure(Point firstPoint, Point secondPoint, Point thirdPoint, Point forthPoint, Point origin) {
        points = new HashSet<>();
        points.add(firstPoint);
        points.add(secondPoint);
        points.add(thirdPoint);
        points.add(forthPoint);
        setPointsToTheOriginOfThisFigure(origin);
        setSegmentsOfTheFigure();
    }

    private void setPointsToTheOriginOfThisFigure(Point origin) {
        points.forEach(p -> p.setToAnOtherOrigin(origin));
    }

    private void setSegmentsOfTheFigure() {
        List<Point> allPoints = new ArrayList<>(points);
        Point leftDown = allPoints.get(0);
        Point leftUp = allPoints.get(0);
        Point rightDown = allPoints.get(0);
        Point rightUp = allPoints.get(0);
        for (Point p : allPoints) {
            if (p.getX() <= leftDown.getX() && p.getY() <= leftDown.getY())
                leftDown = p;
            else if (p.getX() <= leftUp.getX() && p.getY() >= leftUp.getY())
                leftUp = p;
            else if (p.getX() >= rightDown.getX() && p.getY() <= rightDown.getY())
                rightDown = p;
            else if (p.getX() >= rightUp.getX() && p.getY() >= rightUp.getY())
                rightUp = p;
        }
        firstSegment = new Segment(leftDown, leftUp);
        secondSegment = new Segment(leftDown, rightDown);
        thirdSegment = new Segment(rightDown, rightUp);
        forthSegment = new Segment(rightUp, leftUp);
    }

    public List<Segment> getSegmentsOfTheFigure() {
        return Arrays.asList(firstSegment, secondSegment, thirdSegment, forthSegment);
    }

    public Segment getFirstSegment() {
        return firstSegment;
    }

    public void setFirstSegment(Segment firstSegment) {
        this.firstSegment = firstSegment;
    }

    public Segment getSecondSegment() {
        return secondSegment;
    }

    public void setSecondSegment(Segment secondSegment) {
        this.secondSegment = secondSegment;
    }

    public Segment getThirdSegment() {
        return thirdSegment;
    }

    public void setThirdSegment(Segment thirdSegment) {
        this.thirdSegment = thirdSegment;
    }

    public Segment getForthSegment() {
        return forthSegment;
    }

    public void setForthSegment(Segment forthSegment) {
        this.forthSegment = forthSegment;
    }
}
