package it.madlabs.patternrec.web.rest.service;


import it.madlabs.patternrec.web.rest.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;


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
            return new Line(BigDecimal.ONE, BigDecimal.ZERO, new BigDecimal(firstPoint.getX()).negate());
        } if (firstPoint.getY().equals(secondPoint.getY())){
            return new Line(BigDecimal.ZERO, BigDecimal.ONE, new BigDecimal(firstPoint.getY()).negate());
        }

        //Extracting values from points
        BigDecimal x1 = new BigDecimal(firstPoint.getX().toString());
        BigDecimal y1 = new BigDecimal(firstPoint.getY().toString());
        BigDecimal x2 = new BigDecimal(secondPoint.getX().toString());
        BigDecimal y2 = new BigDecimal(secondPoint.getY().toString());
        log.info("calculateLine(x1:=[{}], y1:=[{}], x2:=[{}], y2:=[{}])", x1, y1, x2, y2);
        BigDecimal a = y1.subtract(y2);
        BigDecimal b = x2.subtract(x1);
        BigDecimal c = x1.multiply(y2).subtract(x2.multiply(y1));
        Line line = new Line(a, b, c);
        log.info("line:=[{}])", line);
        return line;
    }



}
