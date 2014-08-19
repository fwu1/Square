
public class PlatDriver {

	public static Point getSupport(Point target, Point center,double r)
	{
		double l=target.distance(center);
		//double rate = r/l;
		Line line= new Line(center,target);
		return line.getPointAt(r);
	}
	
	public static void main(String[] args) {
		Point target= new Point(0,50,200);
		Point c1= new Point(50,50,0);
		double r=30;
		Point c=c1;
		Point support = getSupport(target,c,r);
		support.sub(c);
		System.out.printf("support:%s\n", support.toString());
	}
}
