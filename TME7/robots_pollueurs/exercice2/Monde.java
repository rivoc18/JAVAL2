package exercice2;

import exercice1.*;
import java.util.ArrayList;

public class Monde {
	
	private int dimension;
	private ArrayList<Robot> robots;
	private ListeLIFO[][] terrain;
	
	public Monde(ArrayList<Robot> tab, int dim){
		robots = tab;
		dimension = dim;
		terrain = new ListeLIFO[dimension][dimension];
		int nbPapierGras;
		
		for (int x = 0; x < dimension; x++){
			for (int y = 0; y < dimension; y++){
				
				terrain[x][y] = new ListeLIFO();
				nbPapierGras = (int)(Math.random()*3);
				for (int i = 0; i < nbPapierGras; i++){
					terrain[x][y].push(new PapierGras());
				}
			}
			
		}
	}
	
	public Robot robotEnXY(int i, int j){
		Robot res = null;
		for(int a=0; a<robots.size(); a++){
			if (robots.get(a).i == i && robots.get(a).j == j)
				res = robots.get(a);
		}
		return res;
	}
	
	public String toString(){
		String s = "";
		Robot bot;
		for (int x = 0; x < dimension; x++){
			for (int y = 0; y < dimension; y++){
				
				bot = robotEnXY(x, y);
				if (bot != null)
					s+="  "+ bot.toString();
				else{
					if (terrain[x][y].size() == 0)
						s+="   .";
					else
						s+="   "+terrain[x][y].size();
				}
			}
			s+="\n";
		}
		return s;
	}
	
	public int getDimension(){
		return dimension;
	}
	
	public ListeLIFO getPile(int i, int j){
		return terrain[i][j];
	}
	
	public ListeLIFO[][] getTerrain(){
		return terrain;
	}
	
	public void nextRound(){
		for(int a=0; a<robots.size(); a++){
			robots.get(a).action(this);
			robots.get(a).move(this);
		}
	}
	
}
