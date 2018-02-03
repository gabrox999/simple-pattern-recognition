package it.madlabs.patternrec.web.rest.service;

import it.madlabs.patternrec.web.rest.model.Point;
import it.madlabs.patternrec.web.rest.model.Line;
import it.madlabs.patternrec.web.rest.repository.PointRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class PointService {

    private final Logger log = LoggerFactory.getLogger(PointService.class);

    //this cannot work with huge amount of data
    private Map<Line, Set<Point>> lineMap = new HashMap<Line, Set<Point>>();
    private Set<Point> points = new HashSet<Point>();
    private LineCalculator lineCalculator = new LineCalculator();

    private final PointRepository pointRepository;

    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    @PostConstruct
    public void loadPoints(){
        log.info("Initializing in memory line map and point set");
        //loading initial set of points during application start, it can be done lazy on first request
        List<Point> loadedPoints = pointRepository.findAll();
        log.info("loadedPoints [{}] from repository", loadedPoints.size());
        for (Point point : loadedPoints) {
            log.info("adding point:=[{}] to set", point);
            addPoint(point);
            log.info("point added");
        }
    }

    public void addPoint(Point point) {
        if (point == null ||point.getX() == null || point.getY() == null) {
            throw new IllegalArgumentException("Wrong point data!!! Obtained: " + point);
        }
        log.info("check if [{}] is present in space", point);
        if (points.contains(point)){
            log.info("point is present in space, skipping add operation");
        }else {
            log.info("current point is NOT present!");

            log.info("calculating collinear points");
            calculateCollinearPoints(point);

            log.info("adding point to space");
            points.add(point);

            log.info("main point set:=[{}]", points);
        };
    }

    public void calculateCollinearPoints(Point newPoint) {
        Set<Point> notMatchingPointsInSpace = new HashSet<>(points);
        Set<Line> lineSet = lineMap.keySet();
        log.info("current lineSet has [{}] lines", lineSet.size());
        for (Line line : lineSet) {
            log.info("check if point [{}] belong to line [{}]", newPoint, line);
            if (line.containsPoint(newPoint)){
                log.info("this point belong to the line!");
                Set<Point> pointSet = lineMap.get(line);
                log.info("adding it to the line pointSet");
                pointSet.add(newPoint);
                log.info("removing all line point to not matching point in space");
                notMatchingPointsInSpace.removeAll(pointSet);
            }
        }
        log.info("current not matching point in space are [{}]", notMatchingPointsInSpace.size());
        for (Point oldPoint : notMatchingPointsInSpace) {
            Line line = lineCalculator.calculateLine(newPoint, oldPoint);
            log.info("calculated [{}] line, adding point to its pointSet", line);

            Set<Point> pointSet = new HashSet<>();
            lineMap.put(line, pointSet);

            log.info("adding points [{}, {}] to line [{}] in map", newPoint, oldPoint);
            pointSet.add(oldPoint);
            pointSet.add(newPoint);
            log.info("line:=[{}] current pointSet:=[{}]", line, pointSet);
        }
    }

    public List<List<Point>> allCollinearPoints(Integer n) {
        if (n == null || n == 1) {
            throw new IllegalArgumentException("Wrong parameter!!! Obtained: " + n);
        }
        log.info("search for collinear point");
        List<List<Point>> listOfCollinearPoints = new LinkedList<>();
        for (Line line : lineMap.keySet()) {
            log.info("analyzing line:=[{}]", line);
            Set<Point> currentLinePointSet = lineMap.get(line);
            int linePointSetSize = currentLinePointSet.size();
            log.info("this line has [{}] points", linePointSetSize);
            if (linePointSetSize >= n){
                log.info("size > {}, adding this line to list for return it", n);
                listOfCollinearPoints.add(new LinkedList<>(currentLinePointSet));
            }
        }
        return listOfCollinearPoints;
    }

    public List<Point> allPoints() {
        return new ArrayList<>(points);
    }

    public void deleteAllPoints() {
        points.clear();
        lineMap.clear();
        pointRepository.deleteAll();
    }
}
