public class Emplacement{
	private Carte carte;
	private String nom;
	
	public Emplacement(String nom){
		this.nom = nom;
		this.carte = null;
	}
	
	public Emplacement(String nom, Carte carte){
		this.nom = nom;
		this.carte = carte;
	}

	public String toString(){
		return "|"+carte;
	}
	public boolean estVide(){
		if (carte == null)
			return true;
		return false;
	}
	public boolean poser(Carte carte){
		if (!this.estVide())
			return false;
		this.carte = carte;
		return true;
	}
	public Carte enlever(){
		if (this.carte == null)
			return null;
		Carte save = carte;
		carte = null;
		return save;
	}

	
}
