import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Monde {
	private int tailleX,tailleY;
	private int[][] cases;
	private final double probabilitePresenceInitiale;
	private Joueur J;
	private Dresseur[] dresseurs;
	private int nbDresseurs;
	private int nbDresseursActifs;
	private int nbDresseursMax;
	private boolean termine;
	public Infirmerie centrePokemon;
	public Terrain[][] MAP; //public pour y acceder ailleur dans le main... (on peut faire un getter)
	public static final int SIZE = 32;
	public Fenetre GUI;
	
	public Monde(int tailleX, int tailleY, int nbDresseursMax, Joueur J) {
		dresseurs = new Dresseur[nbDresseursMax];
		this.tailleX=tailleX;
		this.tailleY=tailleY;
		cases = new int[tailleX][tailleY];
		this.nbDresseursMax=nbDresseursMax;
		nbDresseurs=0;
		probabilitePresenceInitiale=0.0005;
		MAP = generationMap();
		nbDresseursActifs=nbDresseurs;
		this.J = J;
		termine=false;
		
		GUI = new Fenetre(getLarg()*Monde.SIZE, getHaut()*Monde.SIZE); //initialisation de la fenetre
	}
	
	public Monde(int tailleX, int tailleY, int nbDresseursMax) {
		this(tailleX,tailleY,nbDresseursMax,new Joueur((int)(Math.random()*tailleX),(int)(Math.random()*tailleY)));
	}
	
	public Monde(Joueur J) {
		this(20,20,20,J);
	}
	
	public Monde() {
		this(20,20,20,new Joueur((int)(Math.random()*20),(int)(Math.random()*20)));
	}
	
	public Terrain[][] generationMap(){
		boolean rivUnique=true;
		boolean rivLigne=true;
		int longueurRiviere=0;
		for(int i = 0;i<tailleX;i++){
			rivLigne=true;
			for(int j = 0;j<tailleY;j++){
				if(cases[i][j] == 0 && i==0 && Math.random()<0.1 && rivUnique){
					cases[i][j]=5;
					rivUnique=false;
				}
				if(cases[i][j] == 0 && precEstRiviere(i,j) && Math.random()<0.46){
					cases[i][j]=5;
					if(rivLigne)
						longueurRiviere++;
					rivLigne=false;
				}
				if(cases[i][j] == 0 && Math.random()<0.3){
					if(estBiome(i,j))
						cases[i][j]=6;
					else if(Math.random()<0.6)
						cases[i][j]=6;
				}
				if(cases[i][j] == 0 && Math.random()<0.05)
					cases[i][j]=4;
				if(cases[i][j]==0)
					cases[i][j]=1;
			}
		}
		if(!rivUnique)	
			for(int j = 0;j<tailleY;j++){
				if(cases[longueurRiviere/2][j]==5){
					cases[longueurRiviere/2][j]=12;
					if(j>0)
						cases[longueurRiviere/2][j-1]=13;
					if(j<tailleY-1)
						cases[longueurRiviere/2][j+1]=13;	
				}
			}	
		int randox=(int)(Math.random()*(tailleX-8)+4);
		int randoy=(int)(Math.random()*(tailleY-8)+4);
		centrePokemon = new Infirmerie(randox,randoy);
		
		//l1
		cases[randox-3][randoy-1]=10;
		cases[randox-3][randoy]=10;
		cases[randox-3][randoy+1]=10;
		cases[randox-3][randoy+2]=10;
		
		//l2
		cases[randox-2][randoy-1]=10;
		cases[randox-2][randoy]=10;
		cases[randox-2][randoy+1]=10;
		cases[randox-2][randoy+2]=10;
		
		//l3
		cases[randox-1][randoy-1]=10;
		cases[randox-1][randoy]=10;
		cases[randox-1][randoy+1]=10;
		cases[randox-1][randoy+2]=10;
		
		//l4
		cases[randox][randoy-1]=10;
		cases[randox][randoy]=7;	//porte
		cases[randox][randoy+1]=10;
		cases[randox][randoy+2]=10;			
		
		cases[randox+1][randoy]=1;
		
		while(nbDresseurs<nbDresseursMax){
			for(int i = 0;i<tailleX;i++)
				for(int j = 0;j<tailleY;j++)
					if(Math.random()<probabilitePresenceInitiale && nbDresseurs<nbDresseursMax && !(cases[i][j]==2) && !((cases[i][j]>=7) && (cases[i][j]<=11)) && !(i==randox+1 && j==randoy)){
						cases[i][j]=2;
						dresseurs[nbDresseurs]= new Dresseur(i,j);
						nbDresseurs++;
					}
		}
		Terrain[][] map;
		map = convMap(); //J'appelle la fonction qui va transformer cases[][] en une map
		return map;
	}
	
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J\n");  
	    System.out.flush();  
	}
	
	public void jouer(){
		J.setPosition(centrePokemon.x+1,centrePokemon.y);
		afficheMondeTerminal();
		//afficheMondeTerminal2();
		while(nbDresseursActifs>0 && !termine){
			for(int i = 0; i<nbDresseurs; i++){
				J.newNiveau(J.calculNiveau());
				dresseurs[i].gagnerNiveauAdversaire(J.calculNiveau());
				if(!dresseurs[i].estVaincu())
					if(J.getX() == dresseurs[i].getX() && J.getY() == dresseurs[i].getY()){
						System.out.println("Vous rencontrez " + dresseurs[i].getAfficherNom() + " ! ");
						Dialogues.randomDialogues(dresseurs[i]);
						if(Waitfor.choixCombattreYN()=='Y'){
							J.combat(dresseurs[i],this);
							Waitfor.waitContinue();
							if(termine)
								break;
							if(cases[J.getX()][J.getY()]==7)
								J.infirmerie();
							J.newNiveau(J.calculNiveau());
							dresseurs[i].gagnerNiveauAdversaire(J.calculNiveau());
							if(dresseurs[i].estVaincu()){
								cases[dresseurs[i].getX()][dresseurs[i].getY()]=3;
								nbDresseursActifs--;
								System.out.println("Dresseurs restants : " + nbDresseursActifs/nbDresseurs);
							}
						}
					}
			}
			afficheMondeTerminal();
			afficheMondeTerminal2();
			if(cases[J.getX()][J.getY()]==6 && Math.random()<0.1){
				int lvlPkmnSauvage=J.getCombattant().getNiveau()-1;
				if (J.getCombattant().getNiveau()>3)
					lvlPkmnSauvage=(int)(Math.random()*3+(J.getCombattant().getNiveau()-3));
				J.combat(Pokemon.pokemonAleatoire(lvlPkmnSauvage),this);
				Waitfor.waitContinue();
				J.newNiveau(J.calculNiveau());
				for(int i = 0; i<nbDresseurs; i++)
					dresseurs[i].gagnerNiveauAdversaire(J.calculNiveau());
				afficheMondeTerminal();
				afficheMondeTerminal2();
			}
			if(cases[J.getX()][J.getY()]==7){
				char choixInfirmerie = Choix.lireChoixDansInfirmerieClavier();
				if(choixInfirmerie=='1'){
					J.infirmerie();
					Waitfor.waitQuit();
				}
				else if(choixInfirmerie=='2'){
					int choixShop=Choix.choixShop(J);
					if(choixShop>=0){
						int qte=Choix.choixNbr();
						J.acheterItem(J.getSac()[choixShop],qte);
						Waitfor.waitQuit();
					}
				}
				clearScreen();
				afficheMondeTerminal();
				afficheMondeTerminal2();
			}
			char choixMonde = Choix.lireChoixDansMondeClavier();
			if(choixMonde=='M'){
				char choixMenu = Choix.lireChoixDansMenuClavier();
				clearScreen();
				if(choixMenu=='1'){
					J.afficherDresseur();
				}
				else if(choixMenu=='2'){
					J.affichePokemons();
					char choixMenuPokemon = Choix.lireChoixDansMenuPokemonClavier(J);
					clearScreen();
					if(choixMenuPokemon=='1'){
						int choixPokemonVoir=Choix.choixPokemonClavier(J);
						if(choixPokemonVoir>=0){
							System.out.println(J.getPokemons()[choixPokemonVoir].getId()+" "+J.getPokemons()[choixPokemonVoir]);
							J.getPokemons()[choixPokemonVoir].afficheAttaques();
							Waitfor.waitQuit();
						}
					}
					else if(choixMenuPokemon == '2'){
						J.echangePokemon();
						Waitfor.waitQuit();
					}
					else if(choixMenuPokemon == '3'){
						J.menuRelachePokemon();
						Waitfor.waitQuit();
					}
				}
				else if(choixMenu=='3'){
					J.afficheSac();
					char choixDansSac = Choix.lireChoixDansMenuSacClavier(J);
					clearScreen();
					J.afficheSac();
					if(choixDansSac=='1'){
						int choixItem = Choix.choixItem(J);	
						if(choixItem<J.tailleSac && choixItem>=0){
							J.getSac()[choixItem].utilise(null,J);
							Waitfor.waitQuit();
						}
					}
					else if(choixDansSac=='2'){
						int choixItem = Choix.choixItem(J);	
						if(choixItem<J.tailleSac && choixItem>=0){
							J.getSac()[choixItem].takeQte(Choix.choixNbr());
							Waitfor.waitQuit();
						}
					}
				}
			}
			else
				peutSeDeplacer(J,choixMonde);
		}
		clearScreen();
		if(nbDresseursActifs==0)
			System.out.println("Vous avez gagné le PokéDéfi.");
		else
			System.out.println("Vous avez échoué le PokéDéfi. Retentez une autre fois !");
		J.afficherDresseur();
	}

	
	public void peutSeDeplacer(Joueur J, char deplacement){
		if(deplacement=='Z'){
			if(J.getX()>0 && !(cases[J.getX()-1][J.getY()]==4) && !((cases[J.getX()-1][J.getY()]>=9) && (cases[J.getX()-1][J.getY()]<=11)) && (!(cases[J.getX()-1][J.getY()]==5) || ((cases[J.getX()-1][J.getY()]==5)&&J.aPokemonEau())))
				J.deplace(-1,0);
		}
		else if(deplacement=='Q'){
			if(J.getY()>0 && !(cases[J.getX()][J.getY()-1]==4) && !((cases[J.getX()][J.getY()-1]>=9) && (cases[J.getX()][J.getY()-1]<=11)) && (!(cases[J.getX()][J.getY()-1]==5) || ((cases[J.getX()][J.getY()-1]==5)&&J.aPokemonEau())))
				J.deplace(0,-1);
		}
		else if(deplacement=='S'){
			if(J.getX()<tailleX-1 && !(cases[J.getX()+1][J.getY()]==4) && !((cases[J.getX()+1][J.getY()]>=9) && (cases[J.getX()+1][J.getY()]<=11)) && (!(cases[J.getX()+1][J.getY()]==5) || ((cases[J.getX()+1][J.getY()]==5)&&J.aPokemonEau())))
				J.deplace(1,0);
		}
		else if(deplacement=='D'){
			if(J.getY()<tailleY-1 && !(cases[J.getX()][J.getY()+1]==4) && !((cases[J.getX()][J.getY()+1]>=9) && (cases[J.getX()][J.getY()+1]<=11)) && (!(cases[J.getX()][J.getY()+1]==5) || ((cases[J.getX()][J.getY()+1]==5)&&J.aPokemonEau())))
				J.deplace(0,1);
		}
	}
	
	public int getTailleX(){
		return tailleX;
	}
	
	public int getTailleY(){
		return tailleY;
	}
	
	public int[][] getCases(){
		return cases;
	}
	
	public void termine(){
		termine=true;
	}
	
	public boolean precEstRiviere(int i, int j){
		return (i>0 && j>0 && i<(tailleX-1) && j<(tailleY-1) && (cases[i-1][j-1]==5 || cases[i-1][j]==5 || cases[i-1][j+1]==5));
	}
	
	public boolean estBiome(int i, int j){
		return (i>0 && j>0 && i<(tailleX-1) && j<(tailleY-1) && (cases[i-1][j-1]==6 || cases[i-1][j]==6 || cases[i-1][j+1]==6 || cases[i][j-1] == 6));
	}
	
	/*
	 * je transforme ton cases[][] en terrain[][]   (terrain est une enum que j'ai créée)
	 */
	public Terrain[][] convMap(){
		Terrain[][] map = new Terrain[cases.length][cases[0].length];
		for(int i=0; i<cases.length; i++)
            for(int j=0; j<cases[0].length; j++)
                map[i][j] = Terrain.conv(cases[i][j]);
        return map;
    }
	
	public int getHaut(){
		return MAP.length;
	}
	
	public int getLarg(){
		return MAP[0].length;
	}
	
	public Joueur getJoueur(){return J;}
	
	public void afficheMondeTerminal(){
		GUI.add(new VueTerrain(this));	//calque pour le sol, les chemins, rocher, eau, pont, herbe
		GUI.add(new VueBatiment(this));	//calque pour les batiments
		GUI.add(new VueDresseur(this));	//calque pour les dresseurs et joueur
		GUI.repaint();
	}
	
	
	public void afficheMondeTerminal2(){
		clearScreen();
		String[][] matrice = new String[tailleX][tailleY];
		for(int i = 0;i<tailleX;i++)
			for(int j = 0;j<tailleY;j++){
					switch(cases[i][j]){
					case 0:
						matrice[i][j]="?";
						break;
					case 1:
						matrice[i][j]=(CouleurTerminal.BACKLIGHTGREEN + CouleurTerminal.GREEN + " " + CouleurTerminal.RESET);								//1=Sol
						break;
					case 2:
						matrice[i][j]=(CouleurTerminal.BACKLIGHTGREEN + CouleurTerminal.RED + "D" + CouleurTerminal.RESET);									//2=Dresseur
						break;
					case 3:
						matrice[i][j]=(CouleurTerminal.BACKLIGHTGREEN + CouleurTerminal.BLACK + "X" + CouleurTerminal.RESET);								//3=Dresseur Vaincu
						break;
					case 4:
						matrice[i][j]=(CouleurTerminal.BACKLIGHTGREEN + CouleurTerminal.LIGHTGREY + Character.toString((char)169) + CouleurTerminal.RESET);	//4=Rocher
						break;
					case 5:
						matrice[i][j]=(CouleurTerminal.BACKCYAN + CouleurTerminal.LIGHTCYAN + "~" + CouleurTerminal.RESET);								//5=Eau
						break;
					case 6:
						matrice[i][j]=(CouleurTerminal.BACKLIGHTGREEN  + CouleurTerminal.GREEN + "w" + CouleurTerminal.RESET);								//6=Herbe
						break;
					case 7:
						matrice[i][j]=(CouleurTerminal.BACKLIGHTCYAN + " " + CouleurTerminal.RESET);									//7=Porte CentrePkmn
						break;
					case 8:
						matrice[i][j]=(CouleurTerminal.BACKWHITE + " " + CouleurTerminal.RESET);											//8=Murs CentrePkmn
						break;
					case 9:
						matrice[i][j]=(CouleurTerminal.BACKRED + CouleurTerminal.WHITE + "P" + CouleurTerminal.RESET);									//9=Toit1 CentrePkmn
						break;
					case 10:
						matrice[i][j]=(CouleurTerminal.BACKRED + CouleurTerminal.WHITE +"K" + CouleurTerminal.RESET);									//10=Toit2 CentrePkmn
						break;
					case 11:
						matrice[i][j]=(CouleurTerminal.BACKRED + CouleurTerminal.WHITE +"M" + CouleurTerminal.RESET);									//11=Toit3 CentrePkmn
						break;
					case 12:
						matrice[i][j]=(CouleurTerminal.BACKCYAN + CouleurTerminal.YELLOW+"=" + CouleurTerminal.RESET);							//12=Pont sur eau
						break;
					case 13:
						matrice[i][j]=(CouleurTerminal.BACKLIGHTGREEN  + CouleurTerminal.YELLOW+"=" + CouleurTerminal.RESET);							//13=Ponts sur terre
						break;
					default:
						matrice[i][j]="?";
					}
			}
		matrice[J.getX()][J.getY()]=(CouleurTerminal.BACKLIGHTGREEN  + CouleurTerminal.BLUE + "J" + CouleurTerminal.RESET);
		String s="";
		s+=(CouleurTerminal.BACKWHITE +CouleurTerminal.BLACK +"+" + CouleurTerminal.RESET);
		for(int j = 0;j<tailleY;j++)
			s+=(CouleurTerminal.BACKWHITE +CouleurTerminal.BLACK +"-" + CouleurTerminal.RESET);
		s+=(CouleurTerminal.BACKWHITE +CouleurTerminal.BLACK +"+" + CouleurTerminal.RESET);
		s+="\n";
		for(int i = 0;i<tailleX;i++){
			s+=(CouleurTerminal.BACKWHITE +CouleurTerminal.BLACK +"|" + CouleurTerminal.RESET);
			for(int j = 0;j<tailleY;j++)
				s+=matrice[i][j];
			s+=(CouleurTerminal.BACKWHITE +CouleurTerminal.BLACK +"|" + CouleurTerminal.RESET);
			s+='\n';
		}
		s+=(CouleurTerminal.BACKWHITE +CouleurTerminal.BLACK +"+" + CouleurTerminal.RESET);
		for(int j = 0;j<tailleY;j++)
			s+=(CouleurTerminal.BACKWHITE +CouleurTerminal.BLACK +"-" + CouleurTerminal.RESET);
		s+=(CouleurTerminal.BACKWHITE +CouleurTerminal.BLACK +"+" + CouleurTerminal.RESET);
		s+="\n";
		clearScreen();
		System.out.println(s);
	}
	
}
