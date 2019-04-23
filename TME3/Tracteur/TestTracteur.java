public class TestTracteur{
	public static void main(String[] args){
		Roue r1 = new Roue(120);
		Roue r2 = new Roue(120);
		Roue r3 = new Roue();
		Roue r4 = new Roue();
		Cabine c1 = new Cabine(0.0,"blue");	
		Tracteur t1 = new Tracteur(c1,r1,r2,r3,r4);
		Tracteur t2 = t1.clone();
		t2.peindre("green");
		System.out.println(t1);
		System.out.println(t2);
	}
}
