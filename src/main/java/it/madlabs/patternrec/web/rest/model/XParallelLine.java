package it.madlabs.patternrec.web.rest.model;

public class XParallelLine implements Line{

    private Double x;

    public XParallelLine(Double x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XParallelLine that = (XParallelLine) o;

        return x != null ? x.equals(that.x) : that.x == null;
    }

    @Override
    public int hashCode() {
        return x != null ? x.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "XParallelLine{" +
                "x=" + x +
                '}';
    }
}
