package exercice2;

public class RobotNormal extends RobotNettoyeur{
	
	private int lineAppend;
	private  int columnAppend;
	
	public RobotNormal(int x,int y){
		super(x,y);
		lineAppend = 1;
		columnAppend = 1;
	}
	
	public void move(Monde m){
		//ici on cherche juste a savoir s'il monte ou s'il descend
		//lineAppend = 1 s'il descend, 0 s'il monte
		if (lineAppend == 1 && super.i == m.getDimension()-1)
			lineAppend = -1;
		if (lineAppend == -1 && super.i == 0)
			lineAppend = 1;
	
		//maintenant on regarde juste chaque ligne si on arrive � une extremit� (gauche ou droite) et si oui,
		//on incremente juste le j de lineAppend
		//columnAppend = 1 si on va vers la droite, -1 vers la gauche
		if (columnAppend == 1 && super.j == m.getDimension()-1){
			columnAppend = -1;
			super.i += lineAppend;
		}
		
		else if (columnAppend == -1 && super.j == 0){
			columnAppend = 1;
			super.i += lineAppend;
		}
		//si on n'�tait pas sur un bord on increment i de columnAppend
		else
			super.j += columnAppend;
	}
	
	public void action(Monde m){
		if (m.getTerrain()[i][j].size() > 0){
			m.getTerrain()[i][j].pop();
			System.out.println("Papier retiré");
		}
	}

	public String toString(){
		return "N"+getNumSerie();
	}
}
