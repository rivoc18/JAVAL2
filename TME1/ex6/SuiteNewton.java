public class SuiteNewton{
	private int x;
	private double epsilon;

	public SuiteNewton(int x1, double e1) {
		x = x1;
		epsilon = e1;
	}
	
	public double algo(){
		double u = x/2;

		while (u > Math.sqrt(x) + epsilon || u < Math.sqrt(x) - epsilon)
			u = (u + x/u) / 2;
		return u;
	}
}
