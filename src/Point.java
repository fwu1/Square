
public class Point {
	double x,y,z;
	
	public Point(double x,double y,double z) {
		set(x,y,z);
	}

	public Point clone() {
		return new Point(x,y,z);
	}

	public void set(double x,double y,double z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public void move(double dx,double dy,double dz) {
		x+=dx;
		y+=dy;
		z+=dz;
	}
	
	public double distance(Point p) {
		double dx=p.x-x;
		double dy=p.y-y;
		double dz=p.z-z;
		return Math.sqrt(dx*dx+dy*dy+dz*dz);
	}
	
	public void sub(Point p)
	{
		x-=p.x;
		y-=p.y;
		z-=p.z;
	}
	
	public String toString() {
		return String.format("[%f, %f, %f]", x,y,z);
	}
	
}
