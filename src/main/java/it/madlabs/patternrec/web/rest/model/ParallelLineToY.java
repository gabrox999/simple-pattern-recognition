package it.madlabs.patternrec.web.rest.model;

public class ParallelLineToY implements Line{

    private Double y;

    public ParallelLineToY(Double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParallelLineToY that = (ParallelLineToY) o;

        return y != null ? y.equals(that.y) : that.y == null;
    }

    @Override
    public int hashCode() {
        return y != null ? y.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ParallelLineToY{" +
                "y=" + y +
                '}';
    }
}