
public class Rectangle {
	Point center;		// the position of rectangle's center
	double edge1,edge2; 	// the length of 2 edges
	double angle;		// the angle between edge1 and x axis

	public Rectangle(double centerX,double centerY,double edge1,double edge2,double angle)
	{
		center=new Point(centerX,centerY,0);
		this.edge1=edge1;
		this.edge2=edge2;
		this.angle=angle;
	}
}
