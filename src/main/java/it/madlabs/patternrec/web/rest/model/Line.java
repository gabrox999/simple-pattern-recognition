package it.madlabs.patternrec.web.rest.model;

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

    public static final Line IDENTITY = new Line(0d,0d, 0d);

    private final double a;
    private final double b;
    private final double c;

    public Line(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (line.a != a) return false;
        if (line.b != b) return false;
        return line.c == c;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(a);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(b);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(c);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
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
}