

import java.lang.Math;

public class Line {
	Point start;
	double kx,ky,kz;
	
	// angleDir -- project the line to xoy plane, the angle from x to projected line
	// angleHeight -- the angle from xoy plane to the line;
	
	public Line(Point start, double angleDir, double angleHeight) {
		this.start=start;
		kx=Math.cos(angleDir)*Math.cos(angleHeight);
		ky=Math.sin(angleDir)*Math.cos(angleHeight);
		kz=Math.sin(angleHeight);
	}
	
	public Line(Point start, Point end) {
		this.start=start;
		double length=start.distance(end);
		kx=(end.x-start.x)/length;
		ky=(end.y-start.y)/length;
		kz=(end.z-start.z)/length;
	}

	public Point getPointAt(double pos) {
		Point p=start.clone();
		p.move(kx*pos,ky*pos,kz*pos);
		return p;
	}
	
	public String toString() {
		return String.format("%s-><%f, %f, %f>", start,kx,ky,kz);
	}
	
}
