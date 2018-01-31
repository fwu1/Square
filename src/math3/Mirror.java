package math3;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.geometry.euclidean.threed.Plane;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public class Mirror extends Plane {

	public Mirror(Vector3D p, Vector3D normal, double tolerance) throws MathArithmeticException {
		super(p, normal, tolerance);
	}

	public Vector3D reflection(Vector3D p) {
		double distance=getOffset(p);
		Vector3D r=new Vector3D(1,p,-2*distance,getNormal());
		return r;
	}
}
