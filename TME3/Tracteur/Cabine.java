public class Cabine{
	private double volume;
	private String color;
	
	public Cabine(double vol, String col){
		volume = vol;
		color = col;
	}
	public String toString(){
		return "vol:"+volume+"   Couleur: "+color;
	}
	public void setCouleur(String couleur){
		this.color = couleur;
	}
	public Cabine clone(){
		return new Cabine(this.volume, this.color);
	}
}
