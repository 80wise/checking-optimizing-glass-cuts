package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ArrayList<Segment> allSegments = new ArrayList<>();
        /*allSegments.add(new Segment(new Point(500, 0), new Point(500, 3210)));
        allSegments.add(new Segment(new Point(0, 15), new Point(6000, 15)));
        allSegments.add(new Segment(new Point(2000, 0), new Point(2000, 3210)));
        allSegments.add(new Segment(new Point(500, 1515), new Point(2000, 1515)));

        Figure figure = new Figure(new Point(0, 0), new Point(1500, 0),
                new Point(1500, 1000), new Point(0, 1485), new Point(500, 15));
        allSegments.addAll(figure.getSegmentsOfTheFigure());*/
        allSegments.add(new Segment(new Point(15, 0), new Point(15, 3210)));
        allSegments.add(new Segment(new Point(0, 15), new Point(6000, 15)));
        allSegments.add(new Segment(new Point(1500, 0), new Point(1500, 3210)));
        allSegments.add(new Segment(new Point(15, 1015), new Point(1500, 1015)));
        allSegments.add(new Segment(new Point(15, 2015), new Point(1500, 2015)));
        allSegments.add(new Segment(new Point(15, 3015), new Point(1500, 3015)));
        allSegments.add(new Segment(new Point(2550, 0), new Point(2550, 3210)));
        allSegments.add(new Segment(new Point(1500, 1415), new Point(2550, 1415)));
        allSegments.add(new Segment(new Point(1500, 2815), new Point(2550, 2815)));
        allSegments.add(new Segment(new Point(3991, 0), new Point(3991, 3210)));
        allSegments.add(new Segment(new Point(2550, 515), new Point(3991, 515)));
        allSegments.add(new Segment(new Point(2550, 1015), new Point(3991, 1015)));
        allSegments.add(new Segment(new Point(2550, 1515), new Point(3991, 1515)));
        allSegments.add(new Segment(new Point(2550, 2015), new Point(3991, 2015)));
        allSegments.add(new Segment(new Point(2550, 2765), new Point(3991, 2765)));
        allSegments.add(new Segment(new Point(3250, 2015), new Point(3250, 2765)));
        allSegments.add(new Segment(new Point(4789, 0), new Point(4789, 3210)));
        allSegments.add(new Segment(new Point(3991, 1515), new Point(4789, 1515)));
        allSegments.add(new Segment(new Point(3991, 3015), new Point(4789, 3015)));
        allSegments.add(new Segment(new Point(5843, 0), new Point(5843, 3210)));
        allSegments.add(new Segment(new Point(4789, 1123), new Point(5843, 1123)));
        allSegments.add(new Segment(new Point(5316, 15), new Point(5316, 1123)));


        Figure figure1 = new Figure(new Point(0, 0), new Point(1470, 0),
                new Point(1200, 1000), new Point(0, 1000), new Point(15, 15));
        allSegments.addAll(figure1.getSegmentsOfTheFigure());
        Figure figure2 = new Figure(new Point(0, 0), new Point(1470, 0),
                new Point(1200, 1000), new Point(0, 1000), new Point(15, 1015));
        allSegments.addAll(figure2.getSegmentsOfTheFigure());
        Figure figure3 = new Figure(new Point(15, 0), new Point(1485, 0),
                new Point(1485, 1000), new Point(285, 1000), new Point(15, 2015));
        allSegments.addAll(figure3.getSegmentsOfTheFigure());
        Figure figure4 = new Figure(new Point(0, 0), new Point(798, 0),
                new Point(798, 1485), new Point(0, 1000), new Point(3991, 15));
        allSegments.addAll(figure4.getSegmentsOfTheFigure());
        Figure figure5 = new Figure(new Point(0, 0), new Point(798, 0),
                new Point(798, 1200), new Point(0, 1485), new Point(3991, 1515));
        allSegments.addAll(figure5.getSegmentsOfTheFigure());
        Figure figure6 = new Figure(new Point(15, 0), new Point(685, 0),
                new Point(600, 735), new Point(150, 735), new Point(2550, 2015));
        allSegments.addAll(figure6.getSegmentsOfTheFigure());

        outputSegments(allSegments);
        System.out.println("\n");
        searchAndExclusionOfOverlappedSegments(allSegments);
        outputSegments(allSegments);
        System.out.println("\n Final results");
        optimizationOfTheWork(allSegments);
        outputSegments(allSegments);
    }

    public static void optimizationOfTheWork(ArrayList<Segment> segments) {
        Segment temporarySegment;
        Point temporaryNextPoint;
        Point currentPosition = new Point(0, 0);

        for (int i = 0; i < segments.size(); i++) {
            if (distanceBetweenTwoPoints(currentPosition, segments.get(i).getFirstPoint())
                    >= distanceBetweenTwoPoints(currentPosition, segments.get(i).getSecondPoint())) {
                segments.get(i).exchangePoints();
            }
            temporaryNextPoint = segments.get(i).getFirstPoint();
            for (int j = i + 1; j < segments.size(); j++) {
                if (distanceBetweenTwoPoints(currentPosition, segments.get(j).getFirstPoint())
                        >= distanceBetweenTwoPoints(currentPosition, segments.get(j).getSecondPoint())) {
                    segments.get(j).exchangePoints();
                }
                if (distanceBetweenTwoPoints(currentPosition, temporaryNextPoint)
                        >= distanceBetweenTwoPoints(currentPosition, segments.get(j).getFirstPoint())) {
                    temporarySegment = segments.get(j);
                    segments.set(j, segments.get(i));
                    segments.set(i, temporarySegment);
                    temporaryNextPoint = segments.get(i).getFirstPoint();
                }
            }
            currentPosition = segments.get(i).getSecondPoint();
        }
    }

    public static void searchAndExclusionOfOverlappedSegments(ArrayList<Segment> segments) {
        for (int i = 0; i < segments.size(); i++) {
            for (int j = i + 1; j < segments.size(); j++) {
                if (checkIfAPointBelongsToASegment(segments.get(i), segments.get(j).getFirstPoint())
                        && checkIfAPointBelongsToASegment(segments.get(i), segments.get(j).getSecondPoint())) {
                    segments.remove(segments.get(j));
                }
            }
        }
    }

    public static boolean checkIfAPointBelongsToASegment(Segment segment, Point p) {
        int x = p.getX();
        int y = p.getY();
        int x1 = segment.getFirstPoint().getX();
        int x2 = segment.getSecondPoint().getX();
        int y1 = segment.getFirstPoint().getY();
        int y2 = segment.getSecondPoint().getY();

        if (x2 == x1) {
            return y == x ? x >= x1 && x <= x2 : x >= x2 && x <= x1
                    && y1 <= y2 ? y >= y1 && y <= y2 : y >= y2 && y <= y1;
        }
        return y - y1 == ((y2 - y1) / (x2 - x1)) * (x - x1)
                && x1 <= x2 ? (x >= x1 && x <= x2) : (x >= x2 && x <= x1)
                && y1 <= y2 ? (y >= y1 && y <= y2) : (y >= y2 && y <= y1);
    }

    public static void outputSegments(ArrayList<Segment> segments) {
        segments.forEach(s -> System.out.println(s.getFirstPoint().toString() + ", "
                + s.getSecondPoint().toString()));
    }

    public static double distanceBetweenTwoPoints(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }
}
