package ss14_exception_and_debug.bai_tap;

public class Triangle {
    private int a;
    private int b;
    private int c;

    public Triangle() {
    }

    public Triangle(int a, int b, int c) throws IllegalTriangleException {

        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("a || b || c <= 0");
        } else if (a + b <= c) {
            throw new IllegalTriangleException("a + b <= c");
        } else if (a + c <= b) {
            throw new IllegalTriangleException("a + c <= b");
        } else if (b + c <= a) {
            throw new IllegalTriangleException("b + c <= a");
        } else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
