import java.awt.Rectangle;

public class BigRectangleFilter implements Filter
{
    @Override
    public boolean accept(Object x)
    {
        if (x instanceof Rectangle) {
            Rectangle rect = (Rectangle) x;
            double perimeter = 2 * (rect.getWidth() + rect.getHeight());
            return perimeter > 10;
        }
        return false;
    }
}