import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.zip.DataFormatException;

class Bank{
    String acHolder;
    double Amount;
    long days;
    double get_rate_of_interest(){return 2;}
}

class SBI_Bank extends Bank{
    SBI_Bank(String A, double b, long d)
    {
        acHolder = A;
        Amount = b;
        days = d;
        ZoneId z = ZoneId.systemDefault();
        LocalDate today = LocalDate.now(z);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate Maturity = today.plusDays(days);
        System.out.println("For SBI_Bank");
        System.out.println("The amount is "+(Amount*Math.pow((100+get_rate_of_interest())/100, days)));
        System.out.println("Maturity Date: "+formatter.format(Maturity));
    }
    
    double get_rate_of_interest()
    {
        double rate;
        if(days<7)
            rate = 2;
        else if(days<46)
            rate = 3;
        else if(days<91)
            rate = 4.05;
        else
            rate = 4.10;
        
        return rate;
    }
}

class ICICI_Bank extends Bank{
    ICICI_Bank(String A, double b, long d)
    {
        acHolder = A;
        Amount = b;
        days = d;
        ZoneId z = ZoneId.systemDefault();
        LocalDate today = LocalDate.now(z);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate Maturity = today.plusDays(days);
        System.out.println("For ICICI_Bank");
        System.out.println("The amount is "+(Amount*Math.pow((100+get_rate_of_interest())/100, days)));
        System.out.println("Maturity Date: "+formatter.format(Maturity));
    }
    double get_rate_of_interest()
    {
        double rate;
        if(days<7)
            rate = 2;
        else if(days<15)
            rate = 3.10;
        else if(days<31)
            rate = 3.20;
        else if(days<46)
            rate = 3.50;
        else if(days<91)
            rate = 4.50;
        else if(days<121)
            rate = 4.70;
        else
            rate = 4.90;
        
        return rate;
    }
}

class AXIS_Bank extends Bank{
    AXIS_Bank(String A, double b, long d)
    {
        acHolder = A;
        Amount = b;
        days = d;
        ZoneId z = ZoneId.systemDefault();
        LocalDate today = LocalDate.now(z);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate Maturity = today.plusDays(days);
        System.out.println("For AXIS_Bank");
        System.out.println("The amount is "+(Amount*Math.pow((100+get_rate_of_interest())/100, days)));
        System.out.println("Maturity Date: "+formatter.format(Maturity));
    }
    double get_rate_of_interest()
    {
        double rate;
        if(days<7)
            rate = 2;
        else if(days<31)
            rate = 3.15;
        else if(days<46)
            rate = 3.45;
        else if(days<91)
            rate = 4.05;
        else if(days<121)
            rate = 4.70;
        else
            rate = 5;
        
        return rate;
    }
}

public class Tester1 {
    public static void main(String Args[])throws ParseException
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("Enter 2 Dates. (format: dd-mm-yyyy)");
        Scanner sc = new Scanner(System.in);
        LocalDate date1 = LocalDate.parse(sc.next(), formatter);
        LocalDate date2 = LocalDate.parse(sc.next(), formatter);
        long days = Duration.between(date1.atStartOfDay(), date2.atStartOfDay()).toDays();
        System.out.println("Number of Days: "+days);
        SBI_Bank s = new SBI_Bank("Aayush", 10000, days);
        ICICI_Bank i = new ICICI_Bank("Aayush", 12500, days);
        AXIS_Bank a = new AXIS_Bank("Aayush", 20000, days);
    } 
}
