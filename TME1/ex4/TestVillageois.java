public class TestVillageois{
	public static void main(String[] args){
		Villageois v1 = new Villageois("Didier");
		Villageois v2 = new Villageois("Paulo");
		Villageois v3 = new Villageois("Oussama");
		Villageois v4 = new Villageois("Antoine");

		System.out.println(v1.toString());
		System.out.println(v2.toString());
		System.out.println(v3.toString());
		System.out.println(v4.toString());

		double poidsSoulevable = v1.poidsSouleve() + v2.poidsSouleve() + v3.poidsSouleve() + v4.poidsSouleve();
		System.out.println(poidsSoulevable);
		if (poidsSoulevable >= 100)
			System.out.println("Les villageois ont réussi à soulever le rocher");
		else
			System.out.println("Les villageois n'ont pas réussi à soulever le rocher");
	}
}
