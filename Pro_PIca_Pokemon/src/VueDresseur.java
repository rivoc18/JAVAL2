import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class VueDresseur implements Drawable{
	
	private Monde m;
	
	public VueDresseur(Monde m){
		this.m = m;
	}
	
	public void draw(Graphics g){
		String fileName = "";
		
		for(int h=0; h<m.getHaut(); h++){
			for(int l=0; l<m.getLarg(); l++){
				if(h == m.getJoueur().getY() && l == m.getJoueur().getX()){
					fileName = "player.png";
					try {
						Image img = ImageIO.read(new File(Fenetre.TEXTURES_PATH+fileName));
					    g.drawImage(img,
					    		h*Monde.SIZE + Monde.SIZE/16,
					    		l*Monde.SIZE - Monde.SIZE/16*5,
					    		Monde.SIZE - Monde.SIZE/16*2, 
					    		Monde.SIZE + Monde.SIZE/16*5,
					    		null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(m.MAP[h][l] == Terrain.Dresseur || m.MAP[h][l] == Terrain.DresseurVaincu)
				{
					fileName = "dresseur1.png";
					try {
						Image img = ImageIO.read(new File(Fenetre.TEXTURES_PATH+fileName));
					    g.drawImage(img,
					    		l*Monde.SIZE,
					    		h*Monde.SIZE - Monde.SIZE/16*4,
					    		Monde.SIZE, 
					    		Monde.SIZE + Monde.SIZE/16*4,
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
