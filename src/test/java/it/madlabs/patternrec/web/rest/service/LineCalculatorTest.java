package it.madlabs.patternrec.web.rest.service;

import it.madlabs.patternrec.web.rest.model.Line;
import it.madlabs.patternrec.web.rest.model.ParallelLineToX;
import it.madlabs.patternrec.web.rest.model.ParallelLineToY;
import it.madlabs.patternrec.web.rest.model.RegularLine;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class LineCalculatorTest {

    private LineCalculator lineCalculator = new LineCalculator();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void given_1_1_and_2_2_point_when_calculateLine_then_should_return_RegularLine_with_1_0(){
        Line expected = new RegularLine(1d,0d);
        Line actual = lineCalculator.calculateLine(1d, 1d, 2d, 2d);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void given_x1_eq_x2_point_when_calculateLine_then_should_return_ParalelLineX_with_x(){
        Line expected = new ParallelLineToX(1d);
        Line actual = lineCalculator.calculateLine(1d, 1d, 1d, 2d);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void given_y1_eq_y2_point_when_calculateLine_then_should_return_ParalelLineY_with_y(){
        Line expected = new ParallelLineToY(1d);
        Line actual = lineCalculator.calculateLine(1d, 1d, 2d, 1d);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_1_1_and_1_1_point_when_calculateLine_then_should_throw_IllegalArgumentsException(){
        //Line expected = new Line(1d,0d);
        Line actual = lineCalculator.calculateLine(1d, 1d, 1d, 1d);
        Assert.fail();
    }
}