
public class Etoile {
	
	private String nom;
	private int temperature;
	private int masse;
	
	public Etoile(String nom, int temperature, int masse){
		this.masse = masse;
		this.temperature = temperature;
		this.nom = nom;
	}
	
	public String getNom(){return nom;}
	public int getTemperature(){return temperature;}
	public int getMasse(){return masse;}
	
	public String toString(){
		String s = "";
		s=nom+"[T="+temperature+"K M="+masse+"]";
		return s;
	}
}
