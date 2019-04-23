/*
import Pokemons.Pokemon;
import Pokemons.Bulbizarre;
import Pokemons.Racaillou;
import Pokemons.Pikachu;
import Pokemons.Salameche;
import Pokemons.Carapuce;
import Dresseurs.Dresseur;
import Dresseurs.Joueur; */

public class Jeu{

	public static void main(String[] args) {
		
		char choixPartie = Choix.lireChoixPartie();
		
		if(choixPartie=='1'){
			Partie Jeu = new Partie();
			Jeu.getMonde().jouer();
		}
		
		else if(choixPartie=='2'){
			Pikachu Pika = new Pikachu("Pikachu",230,90,115);
			Pika.nomPerso=true;
			Carapuce Cara = new Carapuce("Carapuce",250,80,100);
			Cara.nomPerso=true;
			Salameche Salam = new Salameche("Salameche",200,100,110);
			Salam.nomPerso=true;
			Bulbizarre Bulbi = new Bulbizarre("Bulbizarre",280,80,100);
			Bulbi.nomPerso=true;
			Magicarpe Magi = new Magicarpe("Magicarpe",130,60,90);
			Magi.nomPerso=true;
			Pokemon[] listePoke = {Pika,Cara,Bulbi,Salam,Magi};
			
			Joueur X = new Joueur("X",listePoke);
			X.gagneArgent(100000);
			Monde M = new Monde(10,10,3,X);
			M.jouer();
		}
	}
}
