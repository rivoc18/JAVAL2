
public class WMarchandise extends Wagon{
	
	private int poidsMax;
	
	public WMarchandise(String name, int poidsMax,int nbPorte){
		super(name, nbPorte);
		this.poidsMax = poidsMax;
	}
	
	public String toString(){
		return "Wagon Marchandise "+ numSerie;
	}
	
	public int getPoidsMax(){
		return poidsMax;
	}
}
