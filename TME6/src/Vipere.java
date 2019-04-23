public class Vipere extends Animal{
	private static int cmpt = 0;
	private int id;
	
	public Vipere(int x, int y){
		super(x, y, "Vipere");
		id = cmpt;
		cmpt++;
	}
	
	public String toString(){
		return String.format("v%02d", id);
	}
	
	public void afficher(){
		System.out.println("type= "+ super.type +" pos= ("+ super.x +","+ super.y + ") id= "+ toString());
	}
}
