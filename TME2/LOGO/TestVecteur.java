public class TestVecteur{
	public static void main(String[] args){
		Vecteur v1 = new Vecteur(1, 2);
		Vecteur v2 = new Vecteur(v1, new Vecteur(0, 0));
		Vecteur v3 = new Vecteur(v1, new Vecteur(10, 1));
		Vecteur v4 = new Vecteur(new Vecteur(0, 1), Math.PI/2);
		Vecteur v5 = new Vecteur(new Vecteur(1, 1), Math.PI/2);


		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4 +"  (imprecision de Pi)");
		System.out.println(v5);
	}
}
