public class Vecteur{
	
	private double x;
	private double y;
	
	public Vecteur(double x1, double y1){
		x = x1;
		y = y1;
	}
	
	public Vecteur(Vecteur v1, Vecteur v2){
		x = v1.getX() + v2.getX();
		y = v1.getY() + v2.getY();
	}

	public Vecteur(Vecteur v, double T){
		x = v.getX()*Math.cos(T) - v.getY()*Math.sin(T);
		y = v.getX()*Math.sin(T) + v.getY()*Math.cos(T);
	}

	public String toString(){
		String s = "x="+x+", y="+y;
		return s;
	}

	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
}
