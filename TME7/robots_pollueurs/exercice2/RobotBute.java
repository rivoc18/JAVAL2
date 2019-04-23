package exercice2;

public class RobotBute extends RobotPollueur{
	
	private int columnAppend;;
	
	public RobotBute(int x,int y){
		super(x,y);
		columnAppend = 1;
	}
	
	public void move(Monde m){
		if (columnAppend == 1 && super.j == m.getDimension()-1)
			columnAppend = -1;
		if (columnAppend == -1 && super.j == 0)
			columnAppend = 1;
		super.j += columnAppend;
	}
	
	public void action(Monde m){
		if (Math.random() < 0.3){
			PapierGras dechet = new PapierGras();
			m.getTerrain()[i][j].push(dechet);
			System.out.println("Papier posé");
		}
	}
	
	public String toString(){
		return "B"+getNumSerie();
	}
}
