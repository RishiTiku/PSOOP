import java.util.*;

public class clock{
	public int sec, min, hours;
	
	public void conversion1(){
	this.hours = (int)this.sec/3600;
	this.min=(int)(this.sec%3600)/60;
	this.sec%=60;
	}
	
	public void conversion2(){
	this.sec = this.hours*3600+this.min*60+this.sec;
	this.hours = this.min = -1;}
	
	public String toString(){
	String str1 = "", str2 = "", str3 = ""; 
	if(hours == -1 && min == -1)
		return (""+sec);
	if(hours<10)
		str3 = "0";
	if(min<10)
		str1 = "0";
	if(sec<10)
		str2 = "0";
	return(str3+hours+":"+str1+min+":"+str2+sec);}
	
	public static void main(String Args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a time in seconds.");
		clock OB = new clock();
		OB.sec = sc.nextInt();
		OB.conversion1();
		System.out.println("Time in hh:mm:ss: "+OB);
		System.out.println("Enter Hours.");
		OB.hours = sc.nextInt();
		System.out.println("Enter Minutes.");
		OB.min = sc.nextInt();
		System.out.println("Enter Seconds.");
		OB.sec = sc.nextInt();
		OB.conversion2();
		System.out.println("Time in Seconds: "+OB);
	}
}
