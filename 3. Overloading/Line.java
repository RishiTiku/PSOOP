
public class Line{
	float m, c;
	Line(float slope, float intercept){
		m = slope; c = intercept;
	}
	Line(float slope, float yone, float xone){
		m = slope;
		c = yone - xone;
	}
	Line(float yone, float ytwo, float xone, float xtwo){
		m = (ytwo-yone)/(xtwo-xone);
		c = ((ytwo-yone)*xone/(xtwo-xone))+yone;
	}
	public String toString()
	{
		String str = "+";
		int a =1;
		if(c<0)
		{
			str = "-";
			a = -1;
		}
		return "y = "+m+"x "+str+" "+(a*c);
	}
	public static void main(String Args[])
	{
		Line ln1 = new Line(1,2);
		Line ln2 = new Line(1,2,3);
		Line ln3 = new Line(1,2, 3, 4);
		
		System.out.println(ln1);
		System.out.println(ln2);
		System.out.println(ln3);
	}
}
