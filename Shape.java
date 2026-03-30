
public abstract class Shape {

    private Coordinates position;
    private int sides;

    public Shape(int noOfSides, Coordinates coord) {
        this.sides = noOfSides;
        this.position = coord;
    }

    /**
     * Get coordinates
     * @return position
     */
    public Coordinates getCoordinates() {
        return position;
    }

    /**
     * Get number of sides
     * @return sides
     */
    public int getSides() {
        return sides;
    }

    /**
     * Set new coordinates
     * @param newCoord new position
     */
    public void setCoordinates(Coordinates newCoord) {
        this.position = newCoord;
    }

    /**
     * Translate the shape
     * @param dx change in x
     * @param dy change in y
     */
    public void translate(int dx, int dy) {
        position.translate(dx, dy);
    }

    /**
     * Scale the shape
     * @param factor scaling factor
     * @param sign true = multiply, false = divide
     */
    public abstract void scale(int factor, boolean sign);

    /**
     * Calculate area
     * @return area
     */
    public abstract double getArea();

    /**
     * Calculate perimeter
     * @return perimeter
     */
    public abstract double getPerimeter();

    /**
     * Display shape information
     * @return formatted string
     */
    public abstract String display();
}