
public class Gear {

	public static void main(String[] args) {
		int d2=1;
		int d3=1;
		int maxTeeth=19;
		int low=9;
		int min=1000000000;
		//for (int t1=maxTeeth;t1>=low;t1--) {
		for (int t1=low;t1<=maxTeeth;t1++) {
			for (int t2=low;t2<=maxTeeth;t2++) {
				for (int t3=low;t3<=maxTeeth;t3++) {
					for (int t4=low;t4<=maxTeeth;t4++) {
						int n1=2*t1*t3+2*t2*t3 +t1*t4;
						int n2=t1*t4*(t3+t4);
						double r0=1.0*n2/n1;
						//if (t1==18 && t2==8 )
						//	System.out.printf("r0=%f - %d,%d,%d,%d  == n1=%d,n2=%d,min=%d\n",r0,t1,t2,t3,t4,n1,n2,min);
						for (int t6=low;t6<maxTeeth;t6++) {
							int w=t6*n1*d3 - n2*d2;
							if(w!=0) {
								int d0=w;
								if (w<0)
									w=-w;
								if(w<=min) {
									int t5=t3+t4-t6;
									double rate=0;
									rate=((t1+2*t2)*t4*t5)/d0;
									System.out.printf("%f,%.1f,-> %d -- %d,%d,%d,%d,%d\n",r0,rate,d0,t1,t2,t3,t4,t6);
								}
								if(w<min) {
									min=w;
								}
								else {
									//if (t1==18 && t2==8 && t3==10)
									//	System.out.printf("%d,%.5f -- %d,%d,%d,%d,%d\n",d0,r0,t1,t2,t3,t4,t6);
								}
							}
						}
					}
				}
			}
		}
	}

	public static void main_1(String[] args) {
		int maxTeeth=15;
		int low=13;
		int max=0;
		double maxSizeRate=0;
		for (int r1=low;r1<=maxTeeth;r1++) {
			for (int r2=low;r2<=maxTeeth;r2++) {
				for (int r3=low;r3<=maxTeeth;r3++) {
					for (int r4=low;r4<=maxTeeth;r4++) {
						
						int d=r2*r3-r1*r4;
						if(d==1 || d==-1) {
							int speedRate=(r1+2*r2)*(r3+r4);
							int teeth=r1+2*r2;
							if(teeth<r3+2*r4);
								teeth=r3+2*r4;
								
							double sizeRate=speedRate/teeth;
							
							if (sizeRate>0.3*maxSizeRate)
								System.out.printf("%d/%f -- %d,%d,%d,%d\n",d*speedRate,sizeRate,r1,r2,r3,r4);

							if( speedRate>max) {
								max=speedRate;
							}
							if( sizeRate>maxSizeRate) {
								maxSizeRate=sizeRate;
							}
						}
					}
				}
			}
		}
	}
	
}
