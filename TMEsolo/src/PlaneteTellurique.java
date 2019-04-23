
public class PlaneteTellurique extends Planete{
	
	String nom;
	
	public PlaneteTellurique(String nom){
		super(nom);
		this.nom = nom;
	}
	
	public boolean hasAnneaux(){
		return false;
	}
}
