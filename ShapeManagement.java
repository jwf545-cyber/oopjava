import java.util.Scanner;

/**
 * ShapeManagement class contains the main menu
 * for managing shapes.
 */
public class ShapeManagement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShapeList shapeList = new ShapeList();
        int choice = -1;

        do {
            System.out.println("\n===== Shape Management Menu =====");
            System.out.println("1. Add a shape");
            System.out.println("2. Remove a shape by position");
            System.out.println("3. Get information about a shape by position");
            System.out.println("4. Area and perimeter of a shape by position");
            System.out.println("5. Display information of all the shapes");
            System.out.println("6. Translate all the shapes");
            System.out.println("7. Scale all the shapes");
            System.out.println("0. Quit program");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addShapeMenu(scanner, shapeList);
                    break;

                case 2:
                    System.out.print("Enter position to remove: ");
                    if (scanner.hasNextInt()) {
                        int removePos = scanner.nextInt();
                        Shape removed = shapeList.removeShape(removePos);
                        if (removed != null) {
                            System.out.println("Shape removed successfully.");
                        }
                    } else {
                        System.out.println("Invalid input.");
                        scanner.next();
                    }
                    break;

                case 3:
                    System.out.print("Enter position: ");
                    if (scanner.hasNextInt()) {
                        int infoPos = scanner.nextInt();
                        Shape shape = shapeList.getShape(infoPos);
                        if (shape != null) {
                            System.out.println(shape.display());
                        }
                    } else {
                        System.out.println("Invalid input.");
                        scanner.next();
                    }
                    break;

                case 4:
                    System.out.print("Enter position: ");
                    if (scanner.hasNextInt()) {
                        int pos = scanner.nextInt();
                        Shape shape = shapeList.getShape(pos);
                        if (shape != null) {
                            System.out.println("Area = " + shape.getArea());
                            System.out.println("Perimeter = " + shape.getPerimeter());
                        }
                    } else {
                        System.out.println("Invalid input.");
                        scanner.next();
                    }
                    break;

                case 5:
                    System.out.println(shapeList.display());
                    break;

                case 6:
                    System.out.print("Enter x distance: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input.");
                        scanner.next();
                        break;
                    }
                    int dx = scanner.nextInt();

                    System.out.print("Enter y distance: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input.");
                        scanner.next();
                        break;
                    }
                    int dy = scanner.nextInt();

                    shapeList.translateShapes(dx, dy);
                    System.out.println("All shapes translated successfully.");
                    break;

                case 7:
                    System.out.print("Enter scale factor: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input.");
                        scanner.next();
                        break;
                    }
                    int factor = scanner.nextInt();

                    System.out.print("Enter sign (true = multiply, false = divide): ");
                    if (!scanner.hasNextBoolean()) {
                        System.out.println("Invalid input.");
                        scanner.next();
                        break;
                    }
                    boolean sign = scanner.nextBoolean();

                    shapeList.scale(factor, sign);
                    System.out.println("All shapes scaled successfully.");
                    break;

                case 0:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    /**
     * Menu to add a shape
     * @param scanner scanner object
     * @param shapeList shape list
     */
    public static void addShapeMenu(Scanner scanner, ShapeList shapeList) {
        System.out.println("\nChoose shape type:");
        System.out.println("1. Rectangle");
        System.out.println("2. Square");
        System.out.println("3. Circle");
        System.out.println("4. Triangle");
        System.out.print("Enter your choice: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input.");
            scanner.next();
            return;
        }

        int shapeChoice = scanner.nextInt();

        switch (shapeChoice) {
            case 1:
                System.out.print("Enter x coordinate: ");
                int rx = scanner.nextInt();
                System.out.print("Enter y coordinate: ");
                int ry = scanner.nextInt();
                System.out.print("Enter width: ");
                int width = scanner.nextInt();
                System.out.print("Enter length: ");
                int length = scanner.nextInt();

                Rectangle rectangle = new Rectangle(new Coordinates(rx, ry), width, length);
                shapeList.addShape(rectangle);
                System.out.println("Rectangle added successfully.");
                break;

            case 2:
                System.out.print("Enter x coordinate: ");
                int sx = scanner.nextInt();
                System.out.print("Enter y coordinate: ");
                int sy = scanner.nextInt();
                System.out.print("Enter side: ");
                int side = scanner.nextInt();

                Square square = new Square(new Coordinates(sx, sy), side);
                shapeList.addShape(square);
                System.out.println("Square added successfully.");
                break;

            case 3:
                System.out.print("Enter x coordinate: ");
                int cx = scanner.nextInt();
                System.out.print("Enter y coordinate: ");
                int cy = scanner.nextInt();
                System.out.print("Enter radius: ");
                int radius = scanner.nextInt();

                Circle circle = new Circle(new Coordinates(cx, cy), radius);
                shapeList.addShape(circle);
                System.out.println("Circle added successfully.");
                break;

            case 4:
                System.out.print("Enter x1 coordinate: ");
                int x1 = scanner.nextInt();
                System.out.print("Enter y1 coordinate: ");
                int y1 = scanner.nextInt();

                System.out.print("Enter x2 coordinate: ");
                int x2 = scanner.nextInt();
                System.out.print("Enter y2 coordinate: ");
                int y2 = scanner.nextInt();

                System.out.print("Enter x3 coordinate: ");
                int x3 = scanner.nextInt();
                System.out.print("Enter y3 coordinate: ");
                int y3 = scanner.nextInt();

                Triangle triangle = new Triangle(
                        new Coordinates(x1, y1),
                        new Coordinates(x2, y2),
                        new Coordinates(x3, y3)
                );
                shapeList.addShape(triangle);
                System.out.println("Triangle added successfully.");
                break;

            default:
                System.out.println("Invalid shape choice.");
        }
    }
}
