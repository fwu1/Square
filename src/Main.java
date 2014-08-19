
public class Main {

	
	static double  deg(double d) {
		return Math.PI*d/180; 
	}
	
	public static void test_coord() {
		Vector vx= new Vector(1,1,0.5);
		Vector vy= new Vector(0,1.5,0);
		Point orig = new Point(0,2,0);
		Cord c = new Cord(orig,vx,vy);
		System.out.printf("Cord=%s\n", c);
		
		for (int i=0;i<8;i++) {
			double angle=deg(45*i);
			Point p1= new Point(Math.cos(angle),0,Math.sin(angle));
			Point p2= c.getBasePoint(p1);
			Point p1a= c.getPoint(p2);
			double d=p1.distance(p1a);
			System.out.printf("base %s=>%s=>%s,  %f\n", p1,p2,p1a,d);
		}
		
	}

	public static void test_drive() {
		Point orig = new Point(100,100,0);
		
		double p=30;
		double lat=deg(0);
		double decl=deg(0);
		Driver driver = new Driver(orig,lat,decl,p);
		
		for (int i=-4;i<=4;i++) {
			double angle=deg(5*i);
			Point dp= driver.drivePoint(angle);
			System.out.printf("base %d=>%s\n", i,dp);
		}
		
	}
	

	public static void test_mirror() {
		
		double arm=30;
		double lat=deg(33.1);
		double decl=deg(-20);
		double h=500;
		
		//lat=0;
		
		Point driveCenter = new Point(0,100,0);
		Driver driver = new Driver(driveCenter,lat,decl,arm);
		Point target = new Point(0,0,h);
		
		Line driveAxis = new Line(driveCenter,deg(90),lat);
		
		
		Line drive2target_line= new Line(driveCenter,target);
		Point mirrorCenter = drive2target_line.getPointAt(arm);

		Vector vx= new Vector(1,0,0);
		Vector vy= new Vector(0,Math.cos(lat),Math.sin(lat));
		Cord coordDriver = new Cord(driveCenter,vx,vy);
		System.out.printf("Cord=%s\n", coordDriver);
		
		
		Point mirrorCenterInDriver = coordDriver.getPoint(mirrorCenter);
		
		double sunLength =mirrorCenter.distance(target);
		
		Sun sun = new Sun(target,lat,decl,sunLength);
		
		double angle=deg(20);
		
		Point drivePoint= driver.drivePoint(angle);
		Point sunPoint= sun.sunPoint(-angle);
		
		
		System.out.printf("driver center:  %s\n", driveCenter);
		System.out.printf("mirror center:  %s\n", mirrorCenter);
		System.out.printf("mirror center in Driver:  %s\n", mirrorCenterInDriver);
		
		System.out.printf("drive angle:  %f\n", angle);
		System.out.printf("drive point:  %s\n", drivePoint);
		System.out.printf("sun point:  %s\n", sunPoint);
		
		Line mirrorNormal = new Line(drivePoint,mirrorCenter);
		Line mirror2Sun = new Line(mirrorCenter,sunPoint);
		System.out.printf("mirror normal: %s\n", mirrorNormal);
		System.out.printf("mirror to sun: %s\n", mirror2Sun);
		
		
		
	}
	
	public static void test_mirrorCenter() {
		double arm=30;
		double lat=deg(33.1);
		double decl=deg(-20);
		double h=500;
		
		//lat=0;
		
		Point driveBase = new Point(550,50,0);
		Point target = new Point(0,0,h);
		
		Line driveAxis = new Line(driveBase,deg(90),lat);
		for (int i=0;i<4;i++) {
			Point driveCenter = driveAxis.getPointAt(i*100);
			//Driver driver = new Driver(driveCenter,lat,decl,arm);
			
			Line drive2target_line= new Line(driveCenter,target);
			Point mirrorCenter = drive2target_line.getPointAt(arm);
	
			Vector vx= new Vector(1,0,0);
			Vector vy= new Vector(0,Math.cos(lat),Math.sin(lat));
			Cord coordDriver = new Cord(driveCenter,vx,vy);
			//System.out.printf("Cord=%s\n", coordDriver);
			
			
			Point mirrorCenterInDriver = coordDriver.getPoint(mirrorCenter);
			
			
			
			//System.out.printf("driver center:  %s\n", driveCenter);
			//System.out.printf("mirror center:  %s\n", mirrorCenter);
			System.out.printf("mirror center in Driver %d:  %s\n", i,mirrorCenterInDriver);
		}
	}
	
	
	public static void main(String[] args) {
		//test_coord();
		//test_drive();
		//test_mirror();
		test_mirrorCenter();
		//test();
	}
	
	public static void test() {
		double h=500;
		double lat=deg(33);
		double p=40;
		Point top = new Point(0,0,h);
		Line pole = new Line(top,deg(90),lat);
		Point M = new Point(100,100,0);
		
		Line rotAxis = new Line(M,deg(90),lat);
		
		System.out.printf("Top: %s\n\n",top);
		
		for (int i=1;i<=4;i++) {
			Point Mi= rotAxis.getPointAt(i*100);
			Line tline= new Line(Mi,top);
			Point S = tline.getPointAt(p);
			System.out.printf("Mi:  %s\n",Mi);
			System.out.printf("S:   %s\n\n",S);
		}
	}

}
