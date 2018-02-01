package it.madlabs.patternrec.web.rest.model;

/**
 * Abstract a RegularLine based on implicit formula: ax + by + c = 0
 *
 */
public class RegularLine implements Line{

    public static final RegularLine IDENTITY = new RegularLine(0d,0d, 0d);

    private final Double m;
    private final Double q;

    public RegularLine(Double a, Double b, Double c) {
        this.m = -(a/b);
        this.q = -(c/b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegularLine that = (RegularLine) o;

        if (m != null ? !m.equals(that.m) : that.m != null) return false;
        return q != null ? q.equals(that.q) : that.q == null;
    }

    @Override
    public int hashCode() {
        int result = m != null ? m.hashCode() : 0;
        result = 31 * result + (q != null ? q.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RegularLine{" +
                "m=" + m +
                ", q=" + q +
                '}';
    }
}