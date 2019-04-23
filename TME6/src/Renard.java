public class Renard extends Animal{
	private static int cmpt = 0;
	private int id;
	
	public Renard(int x, int y){
		super(x, y, "Renard");
		id = cmpt;
		cmpt++;
	}
	
	public String toString(){
		return String.format("r%02d", id);
	}
	
	public void afficher(){
		System.out.println("type= "+ super.type +" pos= ("+ super.x +","+ super.y + ") id= "+ toString());
	}
}
