import java.awt.Rectangle;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String[] args) {
        ArrayList<Rectangle> rectangles = new ArrayList<>();

        //Rectangles with perimeter over 10
        rectangles.add(new Rectangle(3, 3));
        rectangles.add(new Rectangle(2, 4));
        rectangles.add(new Rectangle(5, 1));
        rectangles.add(new Rectangle(10, 10));
        rectangles.add(new Rectangle(1, 5));

        //Rectangles less than or equal to 10
        rectangles.add(new Rectangle(1, 1));
        rectangles.add(new Rectangle(2, 2));
        rectangles.add(new Rectangle(3, 1));
        rectangles.add(new Rectangle(0, 0));
        rectangles.add(new Rectangle(4, 1));

        BigRectangleFilter bigRectFilter = new BigRectangleFilter();

        System.out.println("All rectangles in the list:");
        System.out.println("---------------------------");
        for (Rectangle r : rectangles) {
            System.out.println("Rectangle: width = " + r.getWidth() + ", height = " + r.getHeight() +
                    ", perimeter = " + (2 * (r.getWidth() + r.getHeight())));
        }

        System.out.println("\nRectangles with a perimeter greater than 10:");
        System.out.println("----------------------------------------------");

        for (Rectangle rect : rectangles) {
            if (bigRectFilter.accept(rect)) {
                System.out.println("Accepted: width = " + rect.getWidth() + ", height = " + rect.getHeight() +
                        ", perimeter = " + (2 * (rect.getWidth() + rect.getHeight())));
            }
        }
    }
}