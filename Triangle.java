
public class Triangle extends Shape {

    private Coordinates p1;
    private Coordinates p2;
    private Coordinates p3;

    public Triangle(Coordinates p1, Coordinates p2, Coordinates p3) {
        super(3, p1);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Coordinates getP1() {
        return p1;
    }

    public Coordinates getP2() {
        return p2;
    }

    public Coordinates getP3() {
        return p3;
    }

    @Override
    public double getPerimeter() {
        double a = p1.distance(p2);
        double b = p2.distance(p3);
        double c = p3.distance(p1);
        return a + b + c;
    }

    @Override
    public double getArea() {
        double a = p1.distance(p2);
        double b = p2.distance(p3);
        double c = p3.distance(p1);

        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public void translate(int dx, int dy) {
        p1.translate(dx, dy);
        p2.translate(dx, dy);
        p3.translate(dx, dy);
        setCoordinates(p1);
    }

    @Override
    public void scale(int factor, boolean sign) {
        if (!sign && factor == 0) {
            System.out.println("Error: factor cannot be zero.");
            return;
        }

        p1.scale(factor, sign);
        p2.scale(factor, sign);
        p3.scale(factor, sign);
        setCoordinates(p1);
    }

    @Override
    public String display() {
        return "Triangle [P1 = (" + p1.display() +
                "), P2 = (" + p2.display() +
                "), P3 = (" + p3.display() +
                "), Area = " + getArea() +
                ", Perimeter = " + getPerimeter() + "]";
    }
}
