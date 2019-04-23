public class TestLettre {
	public static void main(String[] args) {
		for (char cmpt = 'a'; cmpt <= 'z'; cmpt++) {
			Lettre lettre = new Lettre(cmpt);
			System.out.println(lettre.getCodeAscii());
		}

		for (char cmpt = 'a'; cmpt <= 'z'; cmpt++) {
			Lettre lettre2 = new Lettre(cmpt);
			System.out.println(lettre2.getCarac());
		}
	}
}
