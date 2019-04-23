import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class VueTerrain implements Drawable{
	
	private Monde m;
	
	public VueTerrain(Monde m){
		this.m = m;
	}
	
	public void draw(Graphics g){
		String fileName = "";
		
		for(int h=0; h<m.getHaut(); h++){
			for(int l=0; l<m.getLarg(); l++){
				
				if(m.MAP[h][l] == Terrain.Herbe) fileName = "herbe.png";
				else if(m.MAP[h][l] == Terrain.Eau) fileName = "eau.png";
				else if(m.MAP[h][l] == Terrain.PontEau || m.MAP[h][l] == Terrain.PontSol) fileName = "pont.png";
				else if(m.MAP[h][l] == Terrain.Rocher) fileName = "rocher.png";
				else fileName = "sol.png";
				
				try {
					Image img = ImageIO.read(new File(Fenetre.TEXTURES_PATH+fileName));
				    g.drawImage(img, l*Monde.SIZE, h*Monde.SIZE, Monde.SIZE, Monde.SIZE, null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public int getPriority(){return 0;}
}