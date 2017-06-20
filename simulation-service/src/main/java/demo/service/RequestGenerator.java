package demo.service;

import org.springframework.data.geo.Point;

import java.util.List;

public class RequestGenerator implements Runnable{
    private List<Point> points;
    int speed;

    public RequestGenerator(List<Point> points, int speed) {
        this.points = points;
        this.speed = speed;
    }

    @Override
    public void run() {
        double x = points.get(0).getX();
        double y = points.get(0).getY();
        for (int i = 1; i < points.size(); i++) {
            double dx = points.get(i).getX() - points.get(i - 1).getX();
            double dy = points.get(i).getY() - points.get(i - 1).getY();
            if (dx * dx + dy * dy >= speed * speed) {

            } else {

            }
        }
    }

    private void sendPost() {

    }
}
