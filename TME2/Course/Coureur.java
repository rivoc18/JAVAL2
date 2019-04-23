public class Coureur{
	private int nuDossard;
	private double tempsAu100;
	private boolean aLeTemoin;

	public Coureur(int no){
		nuDossard = no;
		tempsAu100 = Math.random()*4 + 12;
		aLeTemoin = false;
	}

	public Coureur(){
		this((int)(1001 * Math.random() - 1));
	}

	public int getNuDossard(){
		return nuDossard;
	}
	public double getTempsAu100(){
		return tempsAu100;
	}
	public boolean getALeTemoin(){
		return aLeTemoin;
	}

	public void setALeTemoin(boolean b){
		aLeTemoin = b;
	}

	public String toString(){
		return nuDossard+" "+tempsAu100+" "+aLeTemoin;
	}

	public void passeTemoin(Coureur c){
		this.setALeTemoin(false);
		c.setALeTemoin(true);
		System.out.println(this.nuDossard+" -> "+c.nuDossard);
	}

	public void courir(){
		System.out.println(this.nuDossard+" cours son 100 m");
	}
}
