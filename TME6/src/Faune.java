public class Faune{
	public static final int TAILLE = 20;
	public static final int NBANIMAUX = 21;
	private Animal[] tab;
	
	public Faune(int nbAnimaux){
		tab = new Animal[nbAnimaux-(nbAnimaux)%3];
		for(int i=0;i<nbAnimaux;i++){
			if (i%3 == 0)
				tab[i] = new Poule((int)(Math.random()*TAILLE), (int)(Math.random()*TAILLE));
			else if (i%3 == 1)
				tab[i] = new Renard((int)(Math.random()*TAILLE), (int)(Math.random()*TAILLE));
			else if (i%3 == 2)
				tab[i] = new Vipere((int)(Math.random()*TAILLE), (int)(Math.random()*TAILLE));
		}
	}
	
	public Faune(){
		tab = new Animal[NBANIMAUX-(NBANIMAUX)%3];
		for(int i=0;i<NBANIMAUX;i++){
			if (i%3 == 0)
				tab[i] = new Poule((int)(Math.random()*TAILLE), (int)(Math.random()*TAILLE));
			else if (i%3 == 1)
				tab[i] = new Renard((int)(Math.random()*TAILLE), (int)(Math.random()*TAILLE));
			else if (i%3 == 2)
				tab[i] = new Vipere((int)(Math.random()*TAILLE), (int)(Math.random()*TAILLE));
		}
	}
	
	public Animal[] getTab(){
		return tab;
	}
	
	
	public String terrain(){
		String[][] terrain = new String[TAILLE][TAILLE];
		String s="";
		for(int y=0;y<TAILLE;y++)
			for(int x=0;x<TAILLE;x++)
					terrain[x][y]=".   ";
		for(int z=0;z<NBANIMAUX;z++) {
			if(tab[z] == null)
				continue;
			else
				terrain[tab[z].getX()][tab[z].getY()]=tab[z].toString()+" ";
		}
		for(int i=0;i<TAILLE;i++)
			s+="____";
		s+="____\n";
		for(int y=0;y<TAILLE;y++)
		{
			s+="|   ";
			for(int x=0;x<TAILLE;x++)
					s+=terrain[x][y];
			s+="|\n";
		}
		s+="|";
		for(int i=0;i<TAILLE;i++)
			s+="____";
		s+="___|\n";
		return s;
	}
	
	public int getIndiceAnimalLePlusProche(Animal requete){
		double min = Double.POSITIVE_INFINITY;
		int imin=0;
		for(int i=0;i<NBANIMAUX;i++)
			if(tab[i]!=null && !(requete.getX()==tab[i].getX()) && !(requete.getY()==tab[i].getY()))
				if(requete.distance(tab[i])<=min){
					min=requete.distance(tab[i]);
					imin=i;
				}
		return imin;
	}
	
	public void etatDeLaFaune(){
		for(int i=0;i<NBANIMAUX;i++){
			if(tab[i]!=null)
				System.out.println(tab[getIndiceAnimalLePlusProche(tab[i])]);
		}
	}
	
	public Animal trouverProie(Animal a, Animal b) {
		if (a.getType().equals("Poule") && b.getType().equals("Renard"))
			return a;
		else if (a.getType().equals("Poule") && b.getType().equals("Vipere"))
			return b;
		else if (a.getType().equals("Renard") && b.getType().equals("Vipere"))
			return a;
		else if (a.getType().equals("Vipere") && b.getType().equals("Renard"))
			return b;
		else if (a.getType().equals("Renard") && b.getType().equals("Poule"))
			return b;
		else if (a.getType().equals("Vipere") && b.getType().equals("Poule"))
			return a;
		return null;
	}
	
	public void update() {
		for(int i=0; i<NBANIMAUX; i++){
			if(tab[i]!=null) {
				tab[i].move(tab[getIndiceAnimalLePlusProche(tab[i])]);
			}
			
			for (int j=0;j<i;j++) {
				if (tab[i] != null && tab[j] != null && tab[j].getX()==tab[i].getX() && tab[j].getY()==tab[i].getY()) {
					Animal proie = trouverProie(tab[i], tab[j]);
					if (proie==tab[i])
						tab[i] = null;
					else if (proie==tab[j])
						tab[j] = null;
				}
			}
		}
	}
	
}
