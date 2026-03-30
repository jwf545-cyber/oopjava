
public class Square extends Shape {

    private int side;

    public Square(Coordinates coord, int side) {
        super(4, coord);
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public void scale(int factor, boolean sign) {
        if (!sign && factor == 0) {
            System.out.println("Error: factor cannot be zero.");
            return;
        }

        getCoordinates().scale(factor, sign);

        if (sign) {
            side *= factor;
        } else {
            side /= factor;
        }
    }

    @Override
    public String display() {
        return "Square [Position = (" + getCoordinates().display() +
                "), Side = " + side +
                ", Area = " + getArea() +
                ", Perimeter = " + getPerimeter() + "]";
    }
}
