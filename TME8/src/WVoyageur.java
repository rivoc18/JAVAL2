
public class WVoyageur extends Wagon {
	
	@SuppressWarnings("unused")
	private int nbPlace;
	
	public WVoyageur(String name, int nbpl,int nbPorte){
		super(name, nbPorte);
		nbPlace = nbpl;
	}
	
	public String toString(){
		return "Wagon Voyageur "+ numSerie;
	}
}
