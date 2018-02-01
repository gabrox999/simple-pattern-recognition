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
        log.info("check if [{}] is present in main set", point);
        if (points.contains(point)){
            log.info("point is present in set, skipping add operation");
        }else {
            log.info("check if current point is NOT present! Calculate lines with other points and adding it to the main set!");
            log.info("calculating lines with other point in main set");
            calculateCollinearLinesAndAddToMap(point, points);
            log.info("adding point to main point set");
            points.add(point);
            log.info("main point set:=[{}]", points);
        };
    }

    public List<Line> calculateCollinearLinesAndAddToMap(Point firstpoint, Set<Point> points) {
        List<Line> lineList = new LinkedList<>();
        for (Point secondPoint : points) {
            Line line = lineCalculator.calculateLine(firstpoint, secondPoint);
            log.info("calculated [{}] line, adding point to its pointSet", line);
            addPointToLinesPointSet(firstpoint, secondPoint, line);
        }
        return lineList;
    }

    private void addPointToLinesPointSet(Point firstPoint, Point secondPoint, Line line) {
        log.info("adding points [{}, {}] to lines in map", firstPoint, secondPoint);
        log.info("check if calculated line is in lines map");
            Set<Point> pointSet = lineMap.get(line);
            if (pointSet == null){
                log.info("line was not present, creating new set for current line");
                pointSet = new HashSet<>();
                lineMap.put(line, pointSet);
            }
            log.info("adding point to line pointSet");
            pointSet.add(firstPoint);
            pointSet.add(secondPoint);
            log.info("line:=[{}] current pointSet:=[{}]", line, pointSet);
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
