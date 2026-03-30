
public class Rectangle extends Shape {

    private int width;
    private int length;

    public Rectangle(Coordinates coord, int width, int length) {
        super(4, coord);
        this.width = width;
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public void scale(int factor, boolean sign) {
        if (!sign && factor == 0) {
            System.out.println("Error: factor cannot be zero.");
            return;
        }

        super.translate(0, 0); // keep parent available, no effect
        getCoordinates().scale(factor, sign);

        if (sign) {
            width *= factor;
            length *= factor;
        } else {
            width /= factor;
            length /= factor;
        }
    }

    @Override
    public String display() {
        return "Rectangle [Position = (" + getCoordinates().display() +
                "), Width = " + width +
                ", Length = " + length +
                ", Area = " + getArea() +
                ", Perimeter = " + getPerimeter() + "]";
    }
}
