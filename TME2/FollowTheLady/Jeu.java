public class Jeu{
	private Emplacement gauche,milieu,droit;
	private Carte cible;

	public Jeu(){
		gauche = new Emplacement("gauche");
		milieu = new Emplacement("milieu");
		droit = new Emplacement("droit");

		Carte c1 = new Carte();
		Carte c2 = new Carte();
		cible = new Carte("Dame ");

		gauche.poser(c1);
		milieu.poser(c2);
		droit.poser(cible);
	}

	public String toString(){
		return gauche+"\n"+milieu+"\n"+droit+"\n";
	}

	public void echanger(Emplacement a, Emplacement b){
		Carte ca = a.enlever();
		Carte cb = b.enlever();;
		a.poser(cb);
		b.poser(ca);
	}

	public void echanger(int i, int j){
		if ((i + j) == 1)
			echanger(gauche, milieu);
		if ((i + j) == 2)
			echanger(gauche, droit);
		if ((i + j) == 3)
			echanger(droit, milieu);
	}

	public boolean choisir(Emplacement a){
		Carte save = a.enlever();
		a.poser(save);
		if (save == cible)
			return true;
		return false;
	}

	public boolean choisir(int i){
		if (i == 0)
			return choisir(gauche);
		if (i == 1)
			return choisir(milieu);
		return choisir(droit);
	}

	public void melanger(){
		int i = (int)(Math.random() * 3);
		int j;
		do {
			j = (int)(Math.random() * 3);
		} while (j == i);
		echanger(i, j);
	}

	public void melanger(int n){
		for (int cmpt = 0; cmpt < n; cmpt++){
			melanger();
		}
	}
}













