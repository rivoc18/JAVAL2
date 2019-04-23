
public abstract class Planete {
	
	private String nom;
	private static int cpt = 1;
	private int rang;
	
	public Planete(String nom){
		this.nom = nom;
		rang = cpt;
		cpt++;
	}
	
	public String getNom(){return nom;}
	public int getRang(){return rang;}
	
	public abstract boolean hasAnneaux();
	
	public String toString(){
		String s = "";
		s = nom+"[anneaux="+hasAnneaux()+", rang="+rang+"]";
		return s;
	}
}
