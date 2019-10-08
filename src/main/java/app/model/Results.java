package app.model;

import app.entities.Point;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private List<Point> points;

    public Results() {
        points = new ArrayList<Point>();
    }

    public void add(Point point) {
        points.add(point);
    }

    public int listSize() {
        return points.size();
    }

    public void clearList() {
        points = new ArrayList<Point>();
    }

    public String list() {
        StringBuilder res = new StringBuilder("<html lang='ru'><head><meta charset='UTF-8'></head><body>");

        // create <table>content</table> string and return it
        res.append(" <table><tr><th>X</th> <th>Y</th><th>R</th><th>Начало работы</th><th>Время работы</th><th>Реузльтат</th></tr>");
        Point current;
        for (int i = points.size() - 1; i >= 0; i--) {
            current = points.get(i);
            if (current.isCorrect()) {
                float x = current.getX();
                float y = current.getY();
                int r = current.getR();
                String creationDateString = current.getCreationDateString();
                String workingTime = current.getWorkingTime();
                boolean result = current.isResult();
                res.append("<tr>");
                res.append("<td>");
                res.append(x);
                res.append("</td>");
                res.append("<td>");
                res.append(y);
                res.append("</td>");
                res.append("<td>");
                res.append(r);
                res.append("</td>");
                res.append("<td>");
                res.append(creationDateString);
                res.append("</td>");
                res.append("<td>");
                res.append(workingTime);
                res.append("</td>");
                res.append("<td>");
                if (result) {
                    res.append("Попала");
                } else {
                    res.append("Не попала");
                }
                res.append("</td>");
            } else {
                res.append("<tr><td colspan='6'><b>Неверные аргументы</b></td></tr>");
            }
        }
        res.append("</body>");

        return res.toString();
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
