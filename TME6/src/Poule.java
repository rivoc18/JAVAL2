public class Poule extends Animal{
	private static int cmpt = 0;
	private int id;
	
	public Poule(int x, int y){
		super(x, y, "Poule");
		id = cmpt;
		cmpt++;
	}
	
	public String toString(){
		return String.format("p%02d", id);
	}
	
	public void afficher(){
		System.out.println("type= "+ super.type +" pos= ("+ super.x +","+ super.y + ") id= "+ toString());
	}
	
}
