public class Range {
    private double from;
    private double to;

    Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    double getFrom() {
        return this.from;
    }

    double getTo() {
        return this.to;
    }

    void setFrom(double from) {
        this.from = from;
    }

    void setTo(double to) {
        this.to = to;
    }

    double getLength() {
        return this.to - this.from;
    }

    boolean isInside(double number) {
        return (number >= this.from && number <= this.to);
    }

    Range getIntersection(Range range) {
        if (range.to <= from || to <= range.from) {
            return null;
        }

        if (from <= range.from) {
            if (range.to <= to) {
                return new Range(range.from, range.to);
            }

            return new Range(range.from, to);
        }

        if (to <= range.to) {
            return new Range(from, to);
        }

        return new Range(from, range.to);
    }

    Range[] getUnion(Range range) {
        if (range.to < from || to < range.from) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        }

        if (from < range.from) {
            if (range.to < to) {
                return new Range[]{new Range(from, to)};
            }

            return new Range[]{new Range(from, range.to)};
        }

        if (to < range.to) {
            return new Range[]{new Range(range.from, range.to)};
        }

        return new Range[]{new Range(range.from, to)};
    }

    Range[] getDifference(Range range) {
        if (to <= range.from || range.to <= from) {
            return new Range[]{new Range(from, to)};
        }

        if (from < range.from) {
            if (range.to < to) {
                return new Range[]{new Range(from, range.from), new Range(range.to, to)};
            }

            return new Range[]{new Range(from, range.from)};
        }

        if (to <= range.to) {
            return new Range[]{};
        }

        return new Range[]{new Range(range.to, to)};
    }

    public String toString() {
        return "{" + from + ", " + to + "}";
    }

    static String arrayToString(Range[] range) {
        if (range.length == 0) {
            return "";
        }

        if (range.length == 1) {
            return range[0].toString();
        }

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < range.length - 1) {
            sb.append(range[i].toString());
            sb.append(", ");
            i++;
        }
        sb.append(range[i].toString());

        return sb.toString();
    }
}
