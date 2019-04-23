import java.awt.Color;

public class TestJeuVie{

	public static void main(String[]args){
		int x = 400, y = 300; // taille de la fenetre
		SimpleInterface ui = new SimpleInterface("Jeu de la Vie",x,y); // fenetre
		Monde m = new Monde(50,50,0.1); // monde 50x50

		ui.createArea( m.getH(), m.getL()); // creation de l'image dans l'interface
		ui.refresh();
		for (int t=0;t<1000;t++){ // mille pas de temps (arbitraire)
			try{Thread.sleep(100);}catch(InterruptedException e){e.printStackTrace();}
			m.genSuiv();
			for (int i=0;i<m.getH();i++)
				for (int j=0;j<m.getL();j++){
					if(m.get(i,j))
						ui.setRGB(i, j, Color.RED);
					else
						ui.setRGB(i, j, Color.WHITE);
				}
			ui.refresh();
		}
	}
}
