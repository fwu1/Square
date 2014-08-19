
public class Sun {

	double lat,decl,length;
	Cord cord;
	
	public Sun(Point location,double lat, double decl, double arm) {
		this.lat=lat;
		this.decl=decl;
		this.length=arm;
		Vector axisX= new Vector(1,0,0);
		Vector axisY= new Vector(0,Math.cos(lat),Math.sin(lat));
		cord= new Cord(location,axisX,axisY);
	}
	
	public Point sunPoint(double angle) {
		double height=length*Math.cos(decl);
		double shift=length*Math.sin(decl);
		Point p=new Point(height*Math.sin(angle),-shift,height*Math.cos(angle));
		return cord.getBasePoint(p);
	}
	
}
