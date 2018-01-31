package it.madlabs.patternrec.web.rest.model;

public class RegularLine implements Line{

    private Double m;
    private Double p;

    public RegularLine(Double m, Double p) {
        this.m = m;
        this.p = p;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegularLine line = (RegularLine) o;

        if (m != null ? !m.equals(line.m) : line.m != null) return false;
        return p != null ? p.equals(line.p) : line.p == null;
    }

    @Override
    public int hashCode() {
        int result = m != null ? m.hashCode() : 0;
        result = 31 * result + (p != null ? p.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Line{" +
                "m=" + m +
                ", p=" + p +
                '}';
    }
}