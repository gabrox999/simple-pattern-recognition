package it.madlabs.patternrec.web.rest.repository;

import it.madlabs.patternrec.web.rest.model.Point;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PointRepository {

    //In the statement is not indicated any persistence, we use this object to fake repository
    //in a production project we should use repository and, maybe, in memory cache
    private List<Point> points = new LinkedList<Point>();

    public PointRepository() {
        points.addAll(Arrays.asList(new Point(2d,3d), new Point(-2d,1023d), new Point(3.2d,0d), new Point(1d,1d)));
    }

    public List<Point> findAll(){
        return points;
    }

    public boolean save(Point point){
        return points.add(point);
    }

    public boolean save(List<Point> points){
        return points.addAll(points);
    }

    public void deleteAll(){
        points.clear();
    }
}
