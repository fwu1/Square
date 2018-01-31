package math3;

import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;
import org.apache.commons.math3.geometry.euclidean.oned.Vector1D;
import org.apache.commons.math3.geometry.euclidean.threed.Plane;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.util.FastMath;

public class Light {
	Vector3D m_direction;
	Vector3D m_emit;
	
	Light() {
		m_direction = new Vector3D(new double[] {0,0,1} );
		m_emit = new Vector3D(new double[] {0,0,0} );
	}
	
	Light(Vector3D direction) {
		m_direction = direction;
		m_emit = new Vector3D(new double[] {0,0,0} );
	}

	Light(Vector3D direction,Vector3D emit) {
		m_direction = direction;
		m_emit = emit;
	}
	
	public Vector3D insection(Plane p) {
		Vector3D w=p.getNormal();
        final double   dot       = w.dotProduct(m_direction);
        if (FastMath.abs(dot) < 1.0e-10) {
            return null;
        }
        double distance= p.getOffset(p);
        return new Vector3D(1.0, m_emit, distance/dot, m_direction);
	}
}
