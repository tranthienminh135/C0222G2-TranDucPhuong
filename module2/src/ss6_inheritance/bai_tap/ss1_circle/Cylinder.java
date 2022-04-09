package ss6_inheritance.bai_tap.ss1_circle;

public class Cylinder extends Circle {
    private float height;

    public Cylinder() {
    }

    public Cylinder(float height) {
        this.height = height;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float surroundingArea() {
        return super.perimeter() * this.height;
    }

    public float totalArea() {
        return this.surroundingArea() + 2 * super.area();
    }

    public float volumn() {
        return super.area() * this.height;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Cylinder{" +
                "Height = " + height +
                ", Surrounding Area = " + this.surroundingArea() +
                ", Total Area = " + this.totalArea() +
                ", Volumn = " + this.volumn() +
                '}';
    }
}
