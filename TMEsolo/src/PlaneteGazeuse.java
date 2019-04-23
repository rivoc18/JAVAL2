
public class PlaneteGazeuse extends Planete{
	
	String nom;
	
	public PlaneteGazeuse(String nom){
		super(nom);
		this.nom = nom;
	}
	
	public boolean hasAnneaux(){
		return true;
	}
}
