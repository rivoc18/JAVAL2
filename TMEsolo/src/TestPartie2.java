
public class TestPartie2 {

	public static void main(String[] args) {
		Etoile soleil = new Etoile("Soleil", 8554457, 1000000);
		PlaneteTellurique mercure = new PlaneteTellurique("Mercure");
		PlaneteTellurique venus = new PlaneteTellurique("Venus");
		PlaneteTellurique terre = new PlaneteTellurique("Terre");
		PlaneteTellurique mars = new PlaneteTellurique("Mars");
		
		PlaneteGazeuse jupiter = new PlaneteGazeuse("Jupiter");
		PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne");
		PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus");
		PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
		
		Orbite o1 = new Orbite(terre);
		Orbite o2 = new Orbite(jupiter);
		for (int i = 0; i<5; i++){
			System.out.println(o1);
			o1.step();
		}
		for (int i = 0; i<5; i++){
			System.out.println(o2);
			o2.step();
		}
	}

}
