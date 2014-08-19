import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.apache.commons.math.linear.ArrayRealVector;
import org.apache.commons.math.linear.DecompositionSolver;
import org.apache.commons.math.linear.LUDecompositionImpl;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.linear.RealVector;

public class Cord {
	Point orig;
	Vector axisX,axisY,axisZ;
	RealMatrix inverse=null; // the matrix to convert to base coordinate
	// Create a co-ordinate that has x axis the same direction with x, and forms z axis with x cross product y,
	// then forms y axis from x and y axis 
	public Cord(Point orig, Vector x, Vector y) {
		this.orig=orig;
		this.axisX=x;
		this.axisX.normlize();
		this.axisY=y;
		this.axisY.normlize();
		this.axisZ=this.axisX.crossProduct(this.axisY);
		this.axisZ.normlize();
		this.axisY=this.axisZ.crossProduct(this.axisX);
		this.axisY.normlize();
	}

	@SuppressWarnings("deprecation")
	private RealMatrix getInverse() {
		if (inverse==null) {
			double [][] values = {
					{axisX.x, axisY.x, axisZ.x}, 
					{axisX.y, axisY.y, axisZ.y}, 
					{axisX.z, axisY.z, axisZ.z} };
			inverse= (new Array2DRowRealMatrix(values)).inverse();
		}
		return inverse;
	}
	
	// get the point in base coordinate with the point in this coordinate
	public Point getBasePoint(Point p) {
		double nx=p.x*axisX.x+p.y*axisY.x+p.z*axisZ.x+orig.x;
		double ny=p.x*axisX.y+p.y*axisY.y+p.z*axisZ.y+orig.y;
		double nz=p.x*axisX.z+p.y*axisY.z+p.z*axisZ.z+orig.z;
		return new Point(nx,ny,nz);
	}
	

	// get the point this coordinate with the point in the base coordinate
	public Point getPoint(Point p) {
		RealMatrix inv=getInverse();
        double [] arrayP = { p.x-orig.x,p.y-orig.y,p.z-orig.z };
        RealVector rvP = new ArrayRealVector(arrayP);
        RealVector rvNP = inv.operate(rvP);
        double[] ap=rvNP.getData();
		double nx=ap[0];
		double ny=ap[1];
		double nz=ap[2];
		return new Point(nx,ny,nz);
	}
	
	public String toString() {
		return String.format("{%s, %s, %s}", axisX,axisY,axisZ);
	}
	
	
	
}
