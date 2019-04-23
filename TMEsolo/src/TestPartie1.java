
public class TestPartie1 {
	public static void main(String[] args){
		Etoile soleil = new Etoile("Soleil", 8554457, 1000000);
		PlaneteTellurique mercure = new PlaneteTellurique("Mercure");
		PlaneteTellurique venus = new PlaneteTellurique("Venus");
		PlaneteTellurique terre = new PlaneteTellurique("Terre");
		PlaneteTellurique mars = new PlaneteTellurique("Mars");
		
		PlaneteGazeuse jupiter = new PlaneteGazeuse("Jupiter");
		PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne");
		PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus");
		PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
		
		System.out.println(soleil);
		System.out.println(mercure);
		System.out.println(mars);
		System.out.println(saturne);
		System.out.println(uranus);
	}
}
