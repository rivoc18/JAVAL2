
public class SystemSolaire {
	
	private Etoile etoile;
	private Orbite[] orbites;
	public static final int MAX_PLANETES = 15;
	private static int cpt = 0;
	
	public SystemSolaire(Etoile e){
		etoile = e;
		orbites = new Orbite[MAX_PLANETES];
	}
	
	public void addPlanete(Planete planete){
		orbites[planete.getRang()] = new Orbite(planete);
	}
	
	public void step(){
		for(int i=0;i<MAX_PLANETES;i++){
			if(orbites[i] != null)
				orbites[i].step();
		}
		cpt++;
	}
	
	public int getNbSteps(){
		return cpt;
	}
	
	public String toString(){
		String s = "Itearation "+cpt+"  --  "+etoile+"\n";
		for(int i=0;i<MAX_PLANETES;i++){
			if (orbites[i] != null)
				s+=orbites[i]+"\n";
		}
		return s;
	}
	
	/*public String findMinDistance(int indOrbiteI, int indOrbiteJ, int nbSteps, double alpha){
		A completer
	}*/
}
