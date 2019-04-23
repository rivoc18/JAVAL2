package exercice1;

import java.util.ArrayList;

public abstract class Liste {
	protected ArrayList<Object> liste;
	
	public Liste(){
		liste = new ArrayList<Object>();
	}
	
	public boolean isEmpty(){
		return size() == 0;
	}
	
	public int size(){
		return liste.size();
	}
	
	public void push(Object o){
		liste.add(size(), o);
	}
	
	public abstract Object pop();
}
