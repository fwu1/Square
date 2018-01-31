package math3;

import org.apache.commons.math3.geometry.euclidean.threed.Line;
import org.apache.commons.math3.geometry.euclidean.threed.Plane;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public class Projection {
	static double tolerance=1e-4;
	public static void main(String[] args) {
		Vector3D camera=new Vector3D(new double[] {0,0,0} );
		double d_mirror=0.12f;  // distance of mirror
		double h_mirror=0.01f; // height of the center of the first mirror
		double d_arm=0.2f;	// length of the arm of second mirror
		Vector3D p_mirror1=new Vector3D(new double[] {0,h_mirror,d_mirror} );
		Vector3D p_mirror2=new Vector3D(new double[] {d_arm, 0,d_mirror} );
		Vector3D p_target=new Vector3D(new double[] {d_arm, 0,d_mirror+1} );
		
		Vector3D ray1=camera.subtract(p_mirror1).normalize();
		Vector3D ray2=p_mirror2.subtract(p_mirror1).normalize();
		Vector3D normal_mirror1=ray1.add(ray2).normalize();

		Vector3D ray3=p_mirror1.subtract(p_mirror2).normalize();
		Vector3D ray4=p_target.subtract(p_mirror2).normalize();
		Vector3D normal_mirror2=ray3.add(ray4).normalize();
		
		
		// normal of mirror1
		System.out.println("camera="+camera);
		System.out.println("ray1="+ray1);
		System.out.println("ray2="+ray2);
		System.out.println("mirror1normal="+normal_mirror1);
		
		System.out.println("ray3="+ray3);
		System.out.println("ray4="+ray4);
		System.out.println("mirror2normal="+normal_mirror2);

		Mirror mirror1= new Mirror(p_mirror1,normal_mirror1,tolerance);
		
		// check how the ray from camera go
		
		Vector3D delta=new Vector3D(new double[] {0*h_mirror,0.0*h_mirror,0} );
		Vector3D v=p_mirror1.add(delta);  // v is target the ray from camera points to
		Line line1 = new Line(camera,v,tolerance); // the line the ray from camera is on
		
		Vector3D p_atMirror1=mirror1.intersection(line1);  // the point where the ray hits on mirror 1
		System.out.println("p_atMirror1="+p_atMirror1);

		Vector3D p_ref_mirror1=mirror1.reflection(camera);  // the point where mirror 1 reflect the camera
		System.out.println("p_ref_camera="+p_ref_mirror1);
		
		Vector3D rayM1to2=p_atMirror1.subtract(p_ref_mirror1).normalize();  //direction of reflected ray
		System.out.println("rayM1to2="+rayM1to2);
		

		Mirror mirror2= new Mirror(p_mirror2,normal_mirror2,tolerance);
		
		Line line2 = new Line(p_atMirror1,p_ref_mirror1,tolerance);  // line of ray from mirror 1 to mirror 2
		Vector3D p_atMirror2=mirror2.intersection(line2);
		System.out.println("p_atMirror2="+p_atMirror2);

		Vector3D p_ref_mirror=mirror2.reflection(p_atMirror1);
		System.out.println("p_ref_mirror1="+p_ref_mirror);
		Vector3D rayM1toOut=p_atMirror2.subtract(p_ref_mirror).normalize();
		System.out.println("rayM1toOut="+rayM1toOut);
		
	}

}
