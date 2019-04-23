
public class Orbite {
	
	private Planete planete;
	private boolean[] position;
	
	public Orbite(Planete planete){
		this.planete = planete;
		position = new boolean[7 * planete.getRang()];
		
		for(int i = 0; i < position.length; i++){
			position[i] = false;
		}
		
		position[(int)(Math.random()*position.length)] = true;
	}
	
	public double getVitesse(){
		return (2.8) / (Math.sqrt(planete.getRang()));
	}
	
	public void step(){
		int i = 0;
		while(position[i] != true) i++;
		
		position[i] = false;
		
		double v = getVitesse();
		double min = v - (int)(v);
		double max = (int)(v+1) - v;
		int nearest = (min < max) ? (int)(v) : (int)(v+1);
		
		position[(i + nearest) % position.length] = true;
	}
	
	public Planete getPlanete(){return planete;}
	
	public String toString(){
		String s = "";
		for(int i = 0; i < position.length; i++){
			if (position[i] == false) s += ".";
			else if (planete.hasAnneaux() == false) s+="o";
			else if (planete.hasAnneaux() == true) s+="O";
		}
		s+=" (planete: "+planete+" v="+getVitesse()+")";
		return s;
	}
	
	public double getPositionAngulaire(){
		int i = 0;
		while(position[i] != true) i++;
		
		return (i/position.length)*360;
	}
	
	public double getDistanceAngulaire(Orbite o){
		double a = Math.abs(getPositionAngulaire() - o.getPositionAngulaire());
		if(a <= 180) return a;
		return 360-a;
	}
}
