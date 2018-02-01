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
            return RegularLine.IDENTITY;
        } if (firstPoint.getX().equals(secondPoint.getX())){
            return new XParallelLine(firstPoint.getX());
        } if (firstPoint.getY().equals(secondPoint.getY())){
            return new YParallelLine(firstPoint.getY());
        }

        //Extracting values from points
        Double x1 = firstPoint.getX();
        Double y1 = firstPoint.getY();
        Double x2 = secondPoint.getX();
        Double y2 = secondPoint.getY();
        log.info("calculateLine(x1:=[{}], y1:=[{}], x2:=[{}], y2:=[{}])", x1, y1, x2, y2);

        Double a = calculateA(y1, y2);
        Double b = calculateB(x1, x2);
        Double c = calculateC(x1, y1, x2, y2);
        RegularLine line = new RegularLine(a, b, c);
        log.info("line:=[{}])", line);
        return line;
    }

    private Double calculateA(Double y1, Double y2){
        log.info("calculateA: (y1 - y2) -> ([{}] - [{}])", y1, y2);
        return (y1 - y2);
    }

    private Double calculateB(Double x1, Double x2){
        log.info("calculateB: (x2 - x1) -> ([{}] - [{}])", x2, x1);
        return (x2 - x1);
    }

    private Double calculateC(Double x1, Double y1, Double x2, Double y2){
        log.info("calculateC: x1 * y2) - (x2 * y1) -> ([{}] * [{}]) - ([{}] * [{}])", x1, y2, x2, y1);
        return (x1 * y2) - (x2 * y1);
    }

}
