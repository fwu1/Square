
public class Vector {
	double x,y,z;
	
	public Vector(double x,double y,double z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}

	public Vector clone() {
		return new Vector(x,y,z);
	}

	public void move(double dx,double dy,double dz) {
		x+=dx;
		y+=dy;
		z+=dz;
	}
	public void normlize() {
		double len= Math.sqrt(x*x+y*y+z*z);
		x=x/len;
		y=y/len;
		z=z/len;
	}
	
	public double dotProduct(Vector v) {
		return x*v.x + y*v.y + z*v.z;
	}
	
	public Vector crossProduct(Vector v) {
		return new Vector(y*v.z-z*v.y, z*v.x-x*v.z, x*v.y-y*v.x);
	}
	
	
	public String toString() {
		return String.format("<%f, %f, %f>", x,y,z);
	}
	
}
