package exercice1;

public class ListeLIFO extends Liste{
	
	public ListeLIFO(){
		super();
	}
	
	public Object pop(){
		return liste.remove(super.size()-1);
	}
}
