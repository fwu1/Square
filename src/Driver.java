
public class Driver {

	double lat,decl,arm;
	Cord cord;
	
	public Driver(Point location,double lat, double decl, double arm) {
		this.lat=lat;
		this.decl=decl;
		this.arm=arm;
		Vector axisX= new Vector(1,0,0);
		Vector axisY= new Vector(0,Math.cos(lat),Math.sin(lat));
		cord= new Cord(location,axisX,axisY);
	}
	
	public Point drivePoint(double angle) {
		double driveHeight=arm*Math.cos(decl);
		double driveShift=arm*Math.sin(decl);
		Point p=new Point(driveHeight*Math.sin(angle),driveShift,-driveHeight*Math.cos(angle));
		return cord.getBasePoint(p);
	}
	
}
