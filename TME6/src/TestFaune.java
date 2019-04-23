public class TestFaune {
	public static void main(String[] args) {
		Faune f = new Faune(); // Ou new Faune(21) suivant vos options
		System.out.println(f.terrain()); // aff. terrain
		for(int i = 1; i<100; i++){
			f.update();
			System.out.println();
			System.out.println(f.terrain()); // aff. terrain
			try{
			     Thread.sleep(100); // 100 ms
			  }catch(Exception e){
			     e.printStackTrace();
			  }
		}
	}
}
