package it.madlabs.patternrec.web.rest.service;


import it.madlabs.patternrec.web.rest.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Class that calculate lines based on 2 passing points
 *
 *
 *
 */
public class LineCalculator {

    private final Logger log = LoggerFactory.getLogger(LineCalculator.class);

    /**
     * Calculate lines based on 2 passing points formula
     * @param firstPoint first point to calculate line
     * @param secondPoint second point to calculate line
     * @return a line
     */
    public Line calculateLine(Point firstPoint, Point secondPoint){

        if (firstPoint.equals(secondPoint)){
            return Line.IDENTITY;
        } if (firstPoint.getX().equals(secondPoint.getX())){
            return new Line(1d, 0d, -firstPoint.getX());
        } if (firstPoint.getY().equals(secondPoint.getY())){
            return new Line(0d, 1d, -firstPoint.getY());
        }

        //Extracting values from points
        Double x1 = firstPoint.getX();
        Double y1 = firstPoint.getY();
        Double x2 = secondPoint.getX();
        Double y2 = secondPoint.getY();
        log.info("calculateLine(x1:=[{}], y1:=[{}], x2:=[{}], y2:=[{}])", x1, y1, x2, y2);

        Double m = calculateM(x1, y1, x2, y2);
        Double q = calculateQ(m, x1, y1);
        Line line = new Line(-m, 1d, -q);
        log.info("line:=[{}])", line);
        return line;
    }

    private Double calculateM(Double x1, Double y1, Double x2, Double y2){
        log.info("calculateM: (y2 - y1) / (x2 - x1) -> ([{}] - [{}]) / ([{}] - [{}])", y2, y1, x2, x1);
        return (y2 - y1) / (x2 - x1);
    }

    private Double calculateQ(Double m, Double x1, Double y1){
        log.info("calculateQ:  y1 - (m* x1) -> [{}] -([{}] * [{}])", y1, m, x1);
        return y1 -(m* x1);
    }

}
