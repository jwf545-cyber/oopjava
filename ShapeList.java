import java.util.ArrayList;

public class ShapeList {

    private ArrayList<Shape> listOfShapes;

    public ShapeList() {
        listOfShapes = new ArrayList<>();
    }

    public void addShape(Shape s) {
        listOfShapes.add(s);
    }

    public void translateShapes(int dx, int dy) {
        for (Shape s : listOfShapes) {
            s.translate(dx, dy);
        }
    }

    public Shape getShape(int pos) {
        if (pos >= 0 && pos < listOfShapes.size()) {
            return listOfShapes.get(pos);
        } else {
            System.out.println("Error: no shape at this position.");
            return null;
        }
    }

    public Shape removeShape(int pos) {
        if (pos >= 0 && pos < listOfShapes.size()) {
            return listOfShapes.remove(pos);
        } else {
            System.out.println("Error: no shape at this position.");
            return null;
        }
    }

    public double area(int pos) {
        Shape s = getShape(pos);
        if (s != null) {
            return s.getArea();
        }
        return 0.0;
    }

    public void scale(int factor, boolean sign) {
        for (Shape s : listOfShapes) {
            s.scale(factor, sign);
        }
    }

    public double perimeter(int pos) {
        Shape s = getShape(pos);
        if (s != null) {
            return s.getPerimeter();
        }
        return 0.0;
    }

    public int getNumberOfShapes() {
        return listOfShapes.size();
    }

    public String display() {
        if (listOfShapes.isEmpty()) {
            return "No shapes in the list.";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < listOfShapes.size(); i++) {
            result.append("Position ").append(i).append(": ")
                    .append(listOfShapes.get(i).display()).append("\n");
        }
        return result.toString();
    }
}