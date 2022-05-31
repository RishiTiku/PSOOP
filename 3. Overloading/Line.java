public class Line{
	float m, c, y1, y2, x1, x2;
	Line(float slope, float intercept){
		m = slope; c = intercept;
		System.out.println(" y = "+m+ "x"+" + "+c);
	}
	Line(float slope, float yone, float xone){
		m = slope; y1 = yone; x1 = xone;
		System.out.println(" y - "+y1+ " = "+m+"(x - "+x1+")");
	}
	Line(float yone, float ytwo, float xone, float xtwo){
		y1 = yone; y2 = ytwo; x1 = xone; x2 = xtwo;
		System.out.println(" y - "+y1+ "\tx - "+x1);
		System.out.println("  -----    =    ----- ");
		System.out.println("   "+(y2-y1)+"\t\t "+(x2-x1));
	}
	public static void main(String Args[])
	{
		Line ln1 = new Line(1,2,3,4);
		Line ln2 = new Line(2,3,4);
		Line l3 = new Line(2, 4);
	}
}
