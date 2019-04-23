
public class TestPartie3 {
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
		
		SystemSolaire s = new SystemSolaire(soleil);
		s.addPlanete(mercure);
		s.addPlanete(venus);
		s.addPlanete(terre);
		s.addPlanete(mars);
		s.addPlanete(jupiter);
		s.addPlanete(saturne);
		s.addPlanete(uranus);
		s.addPlanete(neptune);
		
		for (int i =0; i<100; i++){
			System.out.println(s);
			s.step();
			try {
				Thread.sleep(200);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
