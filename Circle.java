
public class Circle extends Shape {

    private int radius;

    public Circle(Coordinates coord, int radius) {
        super(0, coord);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void scale(int factor, boolean sign) {
        if (!sign && factor == 0) {
            System.out.println("Error: factor cannot be zero.");
            return;
        }

        getCoordinates().scale(factor, sign);

        if (sign) {
            radius *= factor;
        } else {
            radius /= factor;
        }
    }

    @Override
    public String display() {
        return "Circle [Position = (" + getCoordinates().display() +
                "), Radius = " + radius +
                ", Area = " + getArea() +
                ", Perimeter = " + getPerimeter() + "]";
    }
}