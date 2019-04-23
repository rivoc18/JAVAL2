public class Animal{
	
	public static final int TAILLE2 = 20;
	public static final int NBANIMAUX2 = 21;
	
	protected int x, y;
	protected String type;
	
	public Animal(int x, int y, String type){
		this.x=x;
		this.y=y;
		this.type=type;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public String getType(){
		return type;
	}
	
	public double distance(Animal a){
		return Math.sqrt((this.x-a.x)*(this.x-a.x)+(this.y-a.y)*(this.y-a.y));
	}
	
	public void move(int i, int j){
		if (x+i < TAILLE2 && x+i >= 0)
			x+=i;
		if (y+j < TAILLE2 && y+j >= 0)
			y+=j;
	}
	
	public void move(Animal a){
		if (getType().equals("Poule")) {
			if (a.getType().equals("Vipere")) //eloigner
				move((int) Math.signum(-getX() + a.getX()), (int) Math.signum(-getY() + a.getY()));
			else if (a.getType().equals("Renard")) //approcher
				move((int) Math.signum(getX() - a.getX()), (int) Math.signum(getY() - a.getY()));
		}
		else if (getType().equals("Renard")) {
			if (a.getType().equals("Poule")) //eloigner
				move((int) Math.signum(-getX() + a.getX()), (int) Math.signum(-getY() + a.getY()));
			else if (a.getType().equals("Vipere")) //approcher
				move((int) Math.signum(getX() - a.getX()), (int) Math.signum(getY() - a.getY()));
		}
		else if (getType().equals("Vipere")) {
			if (a.getType().equals("Renard")) //eloigner
				move((int) Math.signum(-getX() + a.getX()), (int) Math.signum(-getY() + a.getY()));
			else if (a.getType().equals("Poule")) //approcher
				move((int) Math.signum(getX() - a.getX()), (int) Math.signum(getY() - a.getY()));
		}
	}
	
	public void afficher(){
		System.out.println("Je suis un Animal");
	}
}
	
	
		
	
