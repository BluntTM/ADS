package Week6;

import java.util.*;

class MySet extends HashSet<String> {
    private static final long serialVersionUID = 1L;

    public MySet() {
        super();
    }

    /**
     * @return the union of the elements of this and that
     */
    public MySet union(MySet that) {
        MySet result = new MySet();
        result.addAll(this);

        if (that != null) {
            result.addAll(that);
        }
        return result;
    }

    /**
     * @return the intersection of the elements of this and that
     */
    public MySet intersection(MySet that) {
        MySet result = new MySet();
        for (String s : this) {
            if (that != null && that.contains(s)) {
                result.add(s);
            }
        }
        return result;
    }

    /**
     * @return the difference of the elements of this and that
     */
    public MySet difference(MySet that) {
        MySet result = new MySet();
        for (String s : this) {
            if (that == null || !that.contains(s)) {
                result.add(s);
            }
        }
        return result;
    }

    /**
     * @return the exclusive or (XOR) of the elements of this and that
     */
    public MySet exclusiveOr(MySet that) {
        MySet result = new MySet();
        for (String s : this) {
            if (that == null || !that.contains(s)) {
                result.add(s);
            }
        }
        if (that != null) {
            for (String s : that) {
                if (!this.contains(s)) {
                    result.add(s);
                }
            }
        }
        return result;
    }

    /**
     * @return a String representation of a MySet object
     */
    public String toString() {
        StringBuilder builder = new StringBuilder("<MySet{");
        String end = "}>";

        int i = 0;
        for (String s : this) {
            builder.append(s);
            if (i != this.size() - 1) {
                builder.append(",");
            }
            i++;
        }
        return builder.append(end).toString();
    }
}