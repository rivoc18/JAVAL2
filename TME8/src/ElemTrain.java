
public abstract class ElemTrain {
	protected static int cpt = 0;
	protected int numSerie;
	protected String marque;
	
	public ElemTrain(String s){
		marque = s;
		numSerie = cpt;
		cpt++;
	}
}
