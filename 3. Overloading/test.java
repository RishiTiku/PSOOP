class Test1 {
    double base;
    int power;
    int logbase;
    int argument;
    Test1()
    {
        base = 2;
        power = 2;
        logbase = 2;
        argument = 2;
    }
    public void Display(int a, double val){
        switch(a){
            case 1: System.out.println(base+"^"+power+" = "+val);
                    break;
            case 2: System.out.println("log("+argument+") to base("+logbase+") is "+ val);
                    break;
        }
    }
    public double calculate(double b, int p)
    {
        base = b;
        power = p;
        double val = Math.pow(b,p);
        Display(1, val);
        return val;
    }
    public double calculate(int logbase, int arg)
    {
        this.logbase = logbase;
        argument = arg;
        double val = Math.log(arg)/Math.log(logbase);
        Display(2, val);
        return val;
    }

}

public class test{
    public static void main(String []args)
    {
        Test1 ob = new Test1();
        ob.calculate(10.0, 2);
        ob.calculate(3, 9);
    }
}
