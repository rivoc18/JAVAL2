public class Carte{
	private String nom;

	public Carte(){
		nom = "Valet";
	}

	public Carte(String nom){
		this.nom = nom;
	}

	public String toString(){
		//String s = "+-----+\n|     |\n|     |\n|"+nom+"|\n|     |\n|     |\n+-----+\n";
		String s = nom+"|";
		return s;
	}
}
