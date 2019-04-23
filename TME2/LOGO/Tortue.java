import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Tortue{

	private Vecteur position;
	private Vecteur direction;
	private boolean draw;
	private Graphics g;

	public Tortue(Graphics graph){
		g = graph;
		direction = new Vecteur(1, 0);
		position = new Vecteur(0, 0);
		draw = true;
	}

	public void leverStylo(){
		draw = false;
		//return true;
	}

	public void baisserStylo(){
		draw = true;
		//return false;
	}

	public void avance(double lg){
		int i;
		for (i = 1; i <= lg; i++){
			position = new Vecteur(position, direction);
			if (draw)
				g.drawLine((int) position.getX(), (int) position.getY(), (int) position.getX(), (int) position.getY());
		}
	}

	public void rotation(double theta){
		direction = new Vecteur(direction, theta);
	}
}
