package exercice1;

public class TestLIFO {
	public static void main(String[] args){
		ListeLIFO l = new ListeLIFO();
		l.push(4);
		l.push("a");
		l.push(3.0);
		System.out.println(l.size());
		System.out.println(l.liste.get(l.size()-1));
		l.pop();
		System.out.println(l.size());
		System.out.println(l.liste.get(l.size()-1));
	}
}
