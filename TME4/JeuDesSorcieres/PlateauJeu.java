public class PlateauJeu {
	
	private Piece[] plateau;
	
	public PlateauJeu(Piece[] tab){
		plateau = tab;
	}
	
	public void randomSwap(){
		for(int i = 0; i < 9; i++){
			int pos1 = (int)(Math.random()*9);
			int pos2;
			
			do {
				pos2 = (int)(Math.random()*9);
			} while(pos2 == pos1);
			
			Piece save = plateau[pos1];
			plateau[pos1] = plateau[pos2];
			plateau[pos2] = save;
		}
	}
	
	public void rotationCard(int i){
		plateau[i].rotation();
	}
	
	public PlateauJeu clone(){
		return new PlateauJeu(plateau);
	}
		
	public int nbError(){
		int cptErr = 0;
		//on utilise des operateurs ternaires
		cptErr+=(plateau[0].getD()+ plateau[1].getG()==9) ? 0:1;
		cptErr+=(plateau[1].getD()+ plateau[2].getG()==9) ? 0:1;
		cptErr+=(plateau[3].getD()+ plateau[4].getG()==9) ? 0:1;
		cptErr+=(plateau[4].getD()+ plateau[5].getG()==9) ? 0:1;
		cptErr+=(plateau[6].getD()+ plateau[7].getG()==9) ? 0:1;
		cptErr+=(plateau[7].getD()+ plateau[8].getG()==9) ? 0:1;
		cptErr+=(plateau[0].getB()+ plateau[3].getH()==9) ? 0:1;
		cptErr+=(plateau[1].getB()+ plateau[4].getH()==9) ? 0:1;
		cptErr+=(plateau[2].getB()+ plateau[5].getH()==9) ? 0:1;
		cptErr+=(plateau[3].getB()+ plateau[6].getH()==9) ? 0:1;
		cptErr+=(plateau[4].getB()+ plateau[7].getH()==9) ? 0:1;
		cptErr+=(plateau[5].getB()+ plateau[8].getH()==9) ? 0:1;
		return cptErr;
	}
	
	public void display(){
		System.out.println("   "+plateau[0].getH()+"    "+plateau[1].getH()+"    "+plateau[2].getH()+"\n"+
						   "  "+plateau[0].getG()+"+"+plateau[0].getD()+
						   "  "+plateau[1].getG()+"+"+plateau[1].getD()+
						   "  "+plateau[2].getG()+"+"+plateau[2].getD()+"\n"+
						   "   "+plateau[0].getB()+"    "+plateau[1].getB()+"    "+plateau[2].getB()+"\n"+"\n"+
						   "   "+plateau[3].getH()+"    "+plateau[4].getH()+"    "+plateau[5].getH()+"\n"+
						   "  "+plateau[3].getG()+"+"+plateau[3].getD()+
						   "  "+plateau[4].getG()+"+"+plateau[4].getD()+
						   "  "+plateau[5].getG()+"+"+plateau[5].getD()+"\n"+
						   "   "+plateau[3].getB()+"    "+plateau[4].getB()+"    "+plateau[5].getB()+"\n"+"\n"+
						   "   "+plateau[6].getH()+"    "+plateau[7].getH()+"    "+plateau[8].getH()+"\n"+
						   "  "+plateau[6].getG()+"+"+plateau[6].getD()+
						   "  "+plateau[7].getG()+"+"+plateau[7].getD()+
						   "  "+plateau[8].getG()+"+"+plateau[8].getD()+"\n"+
						   "   "+plateau[6].getB()+"    "+plateau[7].getB()+"    "+plateau[8].getB()+"\n");
	}
}
