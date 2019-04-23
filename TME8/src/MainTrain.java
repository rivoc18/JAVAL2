
public class MainTrain {
	public static void main(String[] args){
		Motrice m = new Motrice("SNCF", 180);
		Train t = new Train(m);
		t.ajoute(new WVoyageur("RATP", 10, 2));
		t.ajoute(new WMarchandise("IDF", 1200, 2));
		t.ajoute(new WMarchandise("TRANSILIEN", 2000, 2));
		System.out.println(t);
		System.out.println(t.poids());
	}
}
