public class Villageois{
	private String nom;
	private double poids;
	private boolean malade = false;

	public Villageois(String nomVillageois){
		double check = Math.random();

		nom = nomVillageois;
		poids = Math.random() * 100 + 50;
		if (check < 0.20)
			malade = true;
	}

	public String getNom(){
		return (nom);
	}

	public double getPoids(){
		return (poids);
	}

	public boolean getMalade(){
		return (malade);
	}

	public String toString(){
		String str;
		if(malade)
			str = "villageois: "+nom+", poids: "+poids+", malade: oui";
		else
			str = "villageois: "+nom+", poids: "+poids+", malade: non";
		return (str);
	}

	public double poidsSouleve(){
		if(malade)
			return (poids / 4);
		return (poids / 3);
	}
}
