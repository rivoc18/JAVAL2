import java.util.ArrayList;
public class Train {
	
	private ArrayList<ElemTrain> train;
	
	public Train(Motrice m){
		train = new ArrayList<ElemTrain>();
		train.add(m);
	}
	
	public void ajoute(Wagon w){
		train.add(w);
	}
	
	public String toString(){
		String s ="";
		for(int i = 0; i < train.size(); i++){
			s+=train.get(i).toString()+"\n";
		}
		return s;
	}
	
	public int poids(){
		int p=0;
		for(ElemTrain e : train){
			if(e instanceof WMarchandise)
				p+=((WMarchandise) e).getPoidsMax();
		}
		return p;
	}
}
