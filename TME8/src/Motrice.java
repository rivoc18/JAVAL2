
public class Motrice extends ElemTrain {
	
	@SuppressWarnings("unused")
	private int puissance;
	
	public Motrice(String name, int p){
		super(name);
		puissance = p;
	}
	
	public String toString(){
		return "Motrice " + numSerie;
	}
}
