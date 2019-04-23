package exercice2;

public abstract class Robot {
	
	protected int i;
	protected int j;
	private static int cpt = 0;
	private int numSerie;
	
	public Robot(int x, int y){
		i = x;
		j  = y;
		numSerie = cpt;
		cpt++;
	}
	
	protected void move(int di,int dj){
		i = i + di;
		j = j + dj;
	}
	
	public int getNumSerie(){
		return numSerie;
	}
	
	abstract void move(Monde m);
	abstract void action(Monde m);
}
