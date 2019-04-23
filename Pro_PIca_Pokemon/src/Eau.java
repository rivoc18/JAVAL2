


public abstract class Eau extends Pokemon{
	protected static String[] faible = {"Eau","Electricite", "Herbe"};
	protected static int nbFaible = 3;
	protected static String[] fort = {"Feu","Terre"};
	protected static int nbFort = 2;
	protected boolean stun;
	public static final String RESET = "\u001B[0m";
	public static final String CYAN = "\u001B[36m";

	public Eau(String nom, int pvmax, int attaque, int speed,int niveau) {
		super(nom ,pvmax, attaque, speed,3,niveau);
		type="Eau";
		stun = false;
		attaquesDisponibles[1]="Hydroblast";
		attaquesDisponibles[2]="Ebullition";
	}

	public abstract void talent();
	
	public void attaque(Pokemon adversaire, String choixAttaque){
		if(!stun){
			System.out.println("\t\t\t\t" + getAfficherNom() + " attaque " + choixAttaque + " ! ");
			if (!choixAttaque.equals("Charge")){
				if(choixAttaque.equals("Hydroblast")){
					if(Math.random()<0.8){
						multiplicateur*=2.2;
						stun=true;
						System.out.println("\t\t\t\t"+ getAfficherNom() + " utilise toutes ses forces ! ");
					}
					else{
						multiplicateur=0;
						System.out.println("\t\t\t\t"+getAfficherNom() + " rate son attaque ! ");
					}
				}
				if(choixAttaque.equals("Ebullition")){
					multiplicateur*=0.8;
					if(Math.random()<0.3){
						adversaire.brulure=true;
						System.out.println("\t\t\t\t" +adversaire.getAfficherNom() +" est brûlé ! ");
					}
				}
				this.attaque(adversaire);
			}
			else{
				System.out.println("\t\t\t\t" + this.getAfficherNom() + " attaque avec un multiplicateur de :" + multiplicateur + " -> " + (int)(attaque*multiplicateur) + " dégats !");
				adversaire.subire(this, (int)(attaque * multiplicateur));
				multiplicateur = 1;
			}
		}
		else{	
			multiplicateur=0;
			System.out.println("\t\t\t\t"+getAfficherNom() + " doit recharger ! ");
			this.attaque(adversaire);
			stun=false;
		}
	}
	
	public String getAfficherNom () {
		return (CouleurTerminal.CYAN+ nom+ CouleurTerminal.RESET);
	}
	
	public String getAfficherId () {
		return (CouleurTerminal.CYAN + nom+ CouleurTerminal.RESET);
	}
	
	public void reset(){
		stun=false;
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
