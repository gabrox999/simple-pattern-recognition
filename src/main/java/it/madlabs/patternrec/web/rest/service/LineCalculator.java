package it.madlabs.patternrec.web.rest.service;

import it.madlabs.patternrec.web.rest.model.Line;
import it.madlabs.patternrec.web.rest.model.ParallelLineToX;
import it.madlabs.patternrec.web.rest.model.ParallelLineToY;
import it.madlabs.patternrec.web.rest.model.RegularLine;
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
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public Line calculateLine(Double x1, Double y1, Double x2, Double y2){
        log.info("calculateLine(x1:=[{}], y1:=[{}], x2:=[{}], y2:=[{}])", x1, y1, x2, y2);
        if (x1.equals(x2) && y1.equals(y2)){
            throw new IllegalArgumentException("Cannot calculate line on single point!");
        } else if (x1.equals(x2)){
            return new ParallelLineToX(x1);
        } else if (y1.equals(y2)){
            return new ParallelLineToY(y1);
        }
        Double m = calculateM(x1, y1, x2, y2);
        Double p = calculateP(x1, y1, m);
        Line line = new RegularLine(m, p);
        log.info("line:=[{}])", line);
        return line;
    }

    private Double calculateM(Double x1, Double y1, Double x2, Double y2){
        log.info("calculateM(x1:=[{}], y1:=[{}], x2:=[{}], y2:=[{}])", x1, y1, x2, y2);
        return (y2 -y1) / (x2 -x1);
    }

    private Double calculateP(Double x1, Double y1, Double m){
        log.info("calculateP(x1:=[{}], y1:=[{}], m:=[{}])", x1, y1, m);
        return y1 - (m * x1);
    }
}
