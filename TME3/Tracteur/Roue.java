public class Roue{
	private int diam;
	
	public Roue(int diametre){
		diam = diametre;
	}
	
	public Roue(){
		this(60);
	}
	
	public String toString(){
		return ""+diam;
	}
	
	public Roue clone(){
		return new Roue(this.diam);
	}
}
