public class TestSegment{
	public static void main(String[] args){
		Segment s1 = new Segment(12, 4);
		Segment s2 = new Segment(12, 5);
		int l1 = s1.longueur();
		int l2 = s2.longueur();

		if (l1 < l2)
			System.out.println("S2 PLUS LONG");
		else
			System.out.println("S1 PLUS LONG");
	}
}
