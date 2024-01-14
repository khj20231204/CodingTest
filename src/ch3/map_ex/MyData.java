package ch3.map_ex;

import java.util.Objects;

class MyData {
    int v;

    public MyData(int v) {
        this.v = v;
    }

    public String toString() {
        return "[" + v + "]";
    }

    @Override
    public int hashCode() {
        int h = Objects.hash(v);
        System.out.println("hash:" + h);
        return h;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("--equals--");

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyData other = (MyData) obj;
        return v == other.v;
    }
}
