public class Mystherbe extends Herbe{
	private static int cpt=1;

	public Mystherbe(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Mystherbe";
	}
	
	public Mystherbe(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed, 1);
	}
	
	public Mystherbe() {
		this("Mystherbe"+cpt, 180+(int)(Math.random()*50), 50+(int)(Math.random()*30), 90+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
	}
	
	public void subire(Adversaire adversaire, int degats){
		if(Math.random()<0.2){
			adversaire.getCombattant().poison=true;
			System.out.println("\t\t\t\t"+adversaire.getCombattant().getAfficherNom() + " a touché le point poison ! ");
		}
		super.subire(adversaire, degats);
	}
	
	public void evolution(){
		if(niveau>=5 && id.equals("Mystherbe")){
			System.out.println("Quoi ?"+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Ortide");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Mystherbe"))
				super.changerNom(id);
			System.out.println(id + " ! ");
			super.evolution();
		}
		if(niveau>=10 && id.equals("Ortide")){
			System.out.println("Quoi ?"+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Raflesia");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Ortide"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}
}
