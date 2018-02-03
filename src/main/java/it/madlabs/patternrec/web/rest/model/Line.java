package it.madlabs.patternrec.web.rest.model;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Abstract a Line based on implicit formula: ax + by + c = 0
 *
 * Note:
 * the explicit form for representing lines is y = m*x + q, but we can't use it to all lines
 * because the equation of parallel lines to x axe are x = c
 * but we can use another equivalent equations, the implicit form, a*x + b*y + c = 0
 * in which we can represent parallel line to x as 1*x + 0*y - c = 0
 * with little maths we can pass from the implicit form to explicit one as y = m*x + q => -m*x + 1 * y - q
 * in this way we can represent all possible lines
 */
public class Line{

    public static final Line IDENTITY = new Line(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);

    private final BigDecimal a;
    private final BigDecimal b;
    private final BigDecimal c;

    public Line(BigDecimal a, BigDecimal b, BigDecimal c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (a != null ? !a.equals(line.a) : line.a != null) return false;
        if (b != null ? !b.equals(line.b) : line.b != null) return false;
        return c != null ? c.equals(line.c) : line.c == null;
    }

    @Override
    public int hashCode() {
        int result = a != null ? a.hashCode() : 0;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (c != null ? c.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Line{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public boolean containsPoint(Point point) {
        BigDecimal xBD = new BigDecimal(point.getX());
        BigDecimal yBD = new BigDecimal(point.getY());
        return a.multiply(xBD).add(b.multiply(yBD)).add(c).stripTrailingZeros().equals(BigDecimal.ZERO);
    }

    public Double calculateYgivenX(double x) {
        BigDecimal xBD = new BigDecimal(x);
        //ax + by + c = 0 => y = - (ax + c) / ba.multiply(xBD).add(b.multiply(yBD)).add(c)
        return a.multiply(xBD).add(c).negate().divide(b).doubleValue();
    }
}