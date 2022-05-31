import java.util.*;

public class Date{

	private int year, month, date, hour, min, sec;
	Date(){
		year = 2000; month = 1;  date = 1;  hour = 0; min = 0; sec = 0;
	}
	public void setDate(int y, int m, int d){
		year = y; month = m; date = d;
	}
	public void setDate(int y, int m, int d, int h, int mi){
		year = y; month = m; date = d; hour = h; min = mi;
	}
	public void setDate(int y, int m, int d, int h, int mi, int s){
		year = y; month = m; date = d; hour = h; min = mi; sec = s;
	}
	public void printDate(int type){
		String strd = "", strm = "", strh = "", strmi = "", strs = "";
		strd = (date<10)?"0":"";
		strm = (month<10)?"0":"";
		strh = (hour<10)?"0":"";
		strmi = (min<10)?"0":"";
		strs = (sec<10)?"0":"";
		switch(type)
			{
				case 1: System.out.println(strd+date+":"+strm+month+":"+year);
						break;
				case 2: System.out.println(strd+date+":"+strm+month+":"+year+", "+strh+hour+":"+strmi+min);
						break;
				case 3: System.out.println(strd+date+":"+strm+month+":"+year+", "+strh+hour+":"+strmi+min+":"+strs+sec);
						break;
				default: System.out.println("Wrong Value.");
			}
	}
	public static void main(String Args[]){
		Date d = new Date();
		Scanner sc = new Scanner(System.in);
		d.setDate(2022, 10, 12);
		d.setDate(2022, 10, 12, 13, 47);
		d.setDate(2022, 10, 12, 13, 47, 3);
		System.out.println("How would you like the Date to be printed?");
		System.out.println("1. dd:mm:yyyy");
		System.out.println("2. dd:mm:yyyy, hh:mm");
		System.out.println("3. dd:mm:yyyy, hh:mm:ss");
		int input = sc.nextInt();
		d.printDate(input);
	}
}
