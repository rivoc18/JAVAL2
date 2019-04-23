
public class Main {
	public static void main(String[] args){
		Piece[] tab = new Piece[]{ new Piece(1,6,7,4), new Piece(3,8,5,4), new Piece(5,3,4,8),
                new Piece(7,8,3,4),new Piece(6,7,3,1),new Piece(5,7,3,1),
                new Piece(4,2,5,8),new Piece(2,8,7,3),new Piece(8,4,2,6)};

		PlateauJeu p = new PlateauJeu(tab);
		Solveur solution = new Solveur(p);
		solution.resoudre();
        p.display();
	}
}
