package exercice2;

public class RobotManiaque extends RobotNettoyeur{
	
	public RobotManiaque(int x,int y){
		super(x,y);
	}
	
	public void move(Monde m){
		int distancemin = m.getDimension();
		int bestI = 0;
		int bestJ = 0;
		
		for(int i = 0; i< m.getDimension(); i++){
			for(int j = 0; j< m.getDimension(); j++){
				if (m.getTerrain()[i][j].size() > 0){
					if (Math.abs((int)(Math.sqrt((super.i - i)*(super.i - i) + (super.j - j)*(super.j - j)))) < distancemin){
						distancemin = Math.abs((int)(Math.sqrt((super.i - i)*(super.i - i) + (super.j - j)*(super.j - j))));
						bestI = i;
						bestJ = j;
					}
				}
			}
		}
		super.i = bestI;
		super.j = bestJ;
	}
	
	public void action(Monde m){
		if (m.getTerrain()[i][j].size() > 0){
			m.getTerrain()[i][j].pop();
			System.out.println("Papier retiré");
		}
	}

	public String toString(){
		return "M"+getNumSerie();
	}
}
