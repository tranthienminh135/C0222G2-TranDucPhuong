package ss7_abstract_class_interface.bai_tap.ss1_interface_resize;

public class Square extends Rectangle {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return super.getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    public double getArea() {
        return this.getSide() * this.getSide();
    }

    public double getPerimeter() {
        return this.getSide() * 4;
    }

    @Override
    public void resize(double percent) {
        this.setSide(this.getSide() * percent);
    }

    @Override
    public String toString() {
        return "Side = " + this.getSide() + "\n" +
                "Area = " + this.getArea() + "\n" +
                "Perimeter = " + this.getPerimeter() + "\n";
    }
}