package exercice2;

public class RobotIdiot extends RobotPollueur{
	
	public RobotIdiot(int x,int y){
		super(x,y);
	}
	
	public void move(Monde m){
		int x, y;
		do {
			x = (int)(Math.random() * 3) - 1;
			y = (int)(Math.random() * 3) - 1;
		} while (super.i+x < 0 || super.i+x >= m.getDimension()
				|| super.j+y < 0 || super.j+y >= m.getDimension()
				|| (x==0 && y==0));
				
		super.move(x, y);
	}
	
	public void action(Monde m){
		if (Math.random() < 0.2){
			PapierGras dechet = new PapierGras();
			m.getTerrain()[i][j].push(dechet);
			System.out.println("Papier posé");
		}
	}
	
	public String toString(){
		return "I"+getNumSerie();
	}
}
