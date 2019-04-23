


public abstract class Terre extends Pokemon{
	protected static String[] faible = {"Eau","Herbe"};
	protected static int nbFaible = 2;
	protected static String[] fort = {"Electricite","Feu","Terre"};
	protected static int nbFort = 3;
	public static final String RESET = "\u001B[0m";
	public static final String YELLOW = "\u001B[33m";

	public Terre(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed,3,niveau);
		type="Terre";
		attaquesDisponibles[1]="Ampleur";
		attaquesDisponibles[2]="Seisme";
	}

	public abstract void talent();
	
	public void attaque(Pokemon adversaire, String choixAttaque){
		System.out.println("\t\t\t\t" + this.getAfficherNom() + " attaque " + choixAttaque + " ! ");
		if (!choixAttaque.equals("Charge")){
			if(choixAttaque.equals("Ampleur")){
				multiplicateur*=Math.random()*0.7+0.8;
			}
			if(choixAttaque.equals("Seisme")){
				multiplicateur*=1.3;
			}
			this.attaque(adversaire);
		}
		else{
			System.out.println("\t\t\t\t" + this.getAfficherNom() + " attaque avec un multiplicateur de :" + multiplicateur + " -> " + (int)(attaque*multiplicateur) + " dégats !");
			adversaire.subire(this, (int)(attaque * multiplicateur));
			multiplicateur = 1;
		}
	}
	
	public String getAfficherNom () {
		return (CouleurTerminal.YELLOW + nom+ CouleurTerminal.RESET);
	}

	public String getAfficherId () {
		return (CouleurTerminal.YELLOW + nom+ CouleurTerminal.RESET);
	}
	
	public void subir(Pokemon adversaire, int degats){
		super.subire(adversaire, degats);
	}
	
	public void evolution(){
		super.evolution();
	}
	
	public String getType(){
		return type;
	}
	
	public String[] getFaible(){
		return faible;
	}
	
	public String[] getFort(){
		return fort;
	}
	
	public int getNbFaible(){
		return nbFaible;
	}
	
	public int getNbFort(){
		return nbFort;
	}

}
