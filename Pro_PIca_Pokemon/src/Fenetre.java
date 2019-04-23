import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Fenetre extends JFrame{

	public static final String TEXTURES_PATH = "../TEXTURES/";
	private ArrayList<Drawable> listToDraw;

	public Fenetre(int l, int h){
		super();
		//this.setSize(15*32, 11*32);
		this.setTitle("Project : POKEMON");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listToDraw = new ArrayList<Drawable>();
		this.setResizable(false);
		JPanel panel = new JPanel(){
            public void paint(Graphics g){
                super.paint(g);
                for(int i=0; i<listToDraw.size(); i++)
                    listToDraw.get(i).draw(g);
            }
        };
        panel.setPreferredSize(new Dimension(l, h));
        panel.setBackground(Color.GRAY);
        this.add(panel);
		this.setVisible(true);
		this.pack();
    }

    public Fenetre(){
    	this(450,550);
    }

    public void add(Drawable d){
        listToDraw.add(d);
        Collections.sort(listToDraw, new Comparator<Drawable>() {
            @Override
            public int compare(Drawable o1, Drawable o2) {
                if(o1.getPriority()<o2.getPriority())
                    return -1;
                if(o1.getPriority()>o2.getPriority())
                    return 1;
                return 0;
            }

        });
    }
}
