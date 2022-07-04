import java.util.*;

public class Tester{
    public static void main(String args[])
    {
        float a, b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2 Values.");
        a = sc.nextFloat();
        b = sc.nextFloat();
        System.out.println("Rectangle Area: "+Area.RectangleArea(a,b));
        System.out.println("Circle Area: "+Area.CircleArea(a));
        System.out.println("Square Area: "+Area.SquareArea(b));
    }
}

abstract class Shape{
    abstract float RectangleArea(float a, float b);
    abstract float CircleArea(float a);
    abstract float SquareArea(float a);
}

class Area{
    public static float RectangleArea(float a, float b)
    {
        return a*b;
    }
    public static float CircleArea(float a)
    {
        return 3.14f*a*a;
    }
    public static float SquareArea(float a)
    {
        return a*a;
    }
}