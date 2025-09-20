public class ShortWordFilter implements Filter
{
    public boolean accept(Object x)
    {
        if (x instanceof String)
        {
            String s = (String) x;
            return s.length() < 5;
        }
        return false;
    }
}
