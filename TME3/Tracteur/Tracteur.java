public class Tracteur{
	private Cabine cab;
	private Roue r1,r2,r3,r4;

	public Tracteur(Cabine cab,Roue r1,Roue r2,Roue r3,Roue r4){
		this.cab = cab;
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
		this.r4 = r4;		
	}
	
	public String toString(){
		return cab+" "+r1+" "+r2+" "+r3+" "+r4;	
	}
	public void peindre(String couleur){
		cab.setCouleur(couleur);
	}
	public Tracteur clone(){
		return new Tracteur(this.cab.clone(), this.r1.clone(), this.r2.clone(), this.r3.clone(), this.r4.clone());
	}
}
