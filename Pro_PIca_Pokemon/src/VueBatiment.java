import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class VueBatiment implements Drawable{
	
	private Monde m;
	
	public VueBatiment(Monde m){
		this.m = m;
	}
	
	public void draw(Graphics g){
		String fileName = "";
		
		for(int h=0; h<m.getHaut(); h++){
			for(int l=0; l<m.getLarg(); l++){
				
				if(m.MAP[h][l] == Terrain.PorteCentrePokemon){
					fileName = "pkmn_center.png";
					try {
						Image img = ImageIO.read(new File(Fenetre.TEXTURES_PATH+fileName));
					    g.drawImage(img,
					    		l*Monde.SIZE - Monde.SIZE,
					    		h*Monde.SIZE - Monde.SIZE*3,
					    		Monde.SIZE*4,
					    		Monde.SIZE*4,
					    		null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public int getPriority(){return 0;}
}