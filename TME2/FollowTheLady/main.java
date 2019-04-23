public class main{
	public static void main(String[] args){
		Jeu game = new Jeu();
		int cmpt = 0;

		System.out.println(game);
		game.echanger(0,2);
		game.melanger(5);
		System.out.println(game);

/*		for (int k = 0; k < 1000; k++){
			game.melanger(100);
			int i = (int)(Math.random() * 3);

			if (game.choisir(i)){
//				System.out.println("Gagne");
				cmpt++;
			}
		}
		System.out.println("nombre de victoires / 1000 tirages: "+cmpt);
*/
	}
}
