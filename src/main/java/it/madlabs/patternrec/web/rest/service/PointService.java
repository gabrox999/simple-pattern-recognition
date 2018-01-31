package it.madlabs.patternrec.web.rest.service;

import it.madlabs.patternrec.web.rest.model.Point;
import it.madlabs.patternrec.web.rest.model.Line;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PointService {

    private Map<Line, Set<Point>> lines = new HashMap<Line, Set<Point>>();
    private Set<Point> points = new HashSet<Point>();

    public PointService() {
    }

    public Point addPoint(Point point) {
        // do some magic!
        return new Point();
    }

    public List<Point> allCollinearPoints(Long n) {
        // do some magic!
        return Collections.emptyList();
    }

    public List<Point> allPoints() {
        // do some magic!
        return Collections.emptyList();
    }

    public void deleteAllPoints() {
        // do some magic!
    }
}
