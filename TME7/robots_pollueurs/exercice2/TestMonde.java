package exercice2;

import java.util.ArrayList;

public class TestMonde {
	public static void main(String[] args){
		int dimension = 20;
		
		ArrayList<Robot> bot = new ArrayList<Robot>();
		bot.add(new RobotNormal((int)(Math.random()*20),(int)(Math.random()*20)));
		bot.add(new RobotIdiot((int)(Math.random()*20),(int)(Math.random()*20)));
		bot.add(new RobotBute((int)(Math.random()*20),(int)(Math.random()*20)));
		bot.add(new RobotManiaque((int)(Math.random()*20),(int)(Math.random()*20)));
	
		Monde m = new Monde(bot, dimension);
		
		for(int i=0; i<1000; i++){
			m.nextRound();
			System.out.println(m);
			try{
			     Thread.sleep(100);
			}catch(Exception e){
			     e.printStackTrace();
			}
		}
	}
}
