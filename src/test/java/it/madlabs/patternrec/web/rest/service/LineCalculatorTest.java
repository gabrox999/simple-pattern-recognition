package it.madlabs.patternrec.web.rest.service;

import it.madlabs.patternrec.web.rest.model.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;


public class LineCalculatorTest {

    private LineCalculator lineCalculator = new LineCalculator();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void given_1_1_and_2_2_point_when_calculateLine_then_should_return_Line_with_m1_1_0(){
        Line expected = new Line(BigDecimal.ONE.negate(), BigDecimal.ONE, BigDecimal.ZERO);
        Line actual = lineCalculator.calculateLine(new Point(1d, 1d), new Point(2d, 2d));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void given_x1_eq_x2_eq_1_points_when_calculateLine_then_should_return_XParallelLive_with_value_1(){
        Line expected = new Line(BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.ONE.negate());
        Line actual = lineCalculator.calculateLine(new Point(1d, 1d), new Point(1d, 2d));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void given_y1_eq_y2_eq_1_points_when_calculateLine_then_should_return_YParallelLive_with_value_1(){
        Line expected = new Line(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.ONE.negate());
        Line actual = lineCalculator.calculateLine(new Point(1d, 1d), new Point(2d, 1d));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void given_1_1_and_1_1_points_when_calculateLine_then_should_return_IDENTITY_line(){
        Line expected = Line.IDENTITY;
        Line actual = lineCalculator.calculateLine(new Point(1d, 1d), new Point(1d, 1d));
        Assert.assertEquals(expected, actual);
    }
}