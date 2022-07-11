import java.util.Scanner;

interface volume{
    void getVolume();
}

interface surfaceArea{
    void getSurfaceArea();
}

class Cylinder implements volume, surfaceArea{
    float height;
    float radius;
    public void getVolume()
    {
        System.out.println("Volume Calculations.");
        System.out.println("Enter height");
        Scanner sc = new Scanner(System.in);
        height = sc.nextFloat();
        System.out.println("Enter Radius");
        radius = sc.nextFloat();
        System.out.println("Volume: "+(3.14*height*radius*radius));
    }
    public void getSurfaceArea()
    {
        System.out.println("Surface Area Calculations.");
        System.out.println("Enter height");
        Scanner sc = new Scanner(System.in);
        height = sc.nextFloat();
        System.out.println("Enter Radius");
        radius = sc.nextFloat();
        System.out.println("Surface Area: "+(2*3.14*height*radius));
    }
}

class tester{
    public static void main(String args[])
    {
        Cylinder ob = new Cylinder();
        ob.getVolume();
        ob.getSurfaceArea();
    }

}