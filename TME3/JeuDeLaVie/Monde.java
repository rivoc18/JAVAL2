public class Monde{
	private int noGener;
	private boolean[][] tabCells;

	public Monde(int dimx, int dimy, double seuil){
		tabCells = new boolean[dimx][dimy];
		for(int x = 0; x < dimx; x++){
			for(int y = 0; y < dimy; y++){
				tabCells[x][y] = (Math.random() < seuil);
			}
		}
		noGener = 0;
	}

	public Monde(int dimx, int dimy, int x, int y, boolean[][] motif){
		int xlength = motif.length;
		int ylength = motif[0].length;

		tabCells = new boolean[dimx][dimy];
		for(int k = 0; k < dimx; k++){
			for(int l = 0; l < dimy; l++){
				tabCells[k][l] = false;
			}
		}
		for (int i = x; i < x + xlength; i++){
			for (int j = y; j < y + ylength; j++){
				tabCells[i][j] = motif[i-x][j-y];
			}
		}
		noGener = 0;
	}

	public int getH(){
		return tabCells.length;
	}

	public int getL(){
		return tabCells[0].length;
	}

	public boolean get(int i, int j){
		return tabCells[i][j];
	}

	public String toString(){
		int dimy = getL();
		int dimx = getH();
		String s;
		s = noGener+"\n";
		for(int x = 0; x < dimx; x++){
			for(int y = 0; y < dimy; y++){
				s = s + (tabCells[x][y]?'*':'.')+" "; 
			}
			s = s +'\n';
		}
		return s;
	}

	public int nbVoisins(int nuLign,int nuCol){
		int dimy = getL();
		int dimx = getH();
		int res = 0;
		for (int i = nuLign-1; i <= nuLign+1; i++){
			int i2 = (i + dimx) % dimx;
			for (int j = nuCol-1; j <= nuCol+1; j++){
				
				int j2 = (j + dimy) % dimy;
				if (tabCells[i2][j2])
						res++;
			}
		}
		if (tabCells[nuLign][nuCol])
			return res - 1;
		return res;
	}

	public void genSuiv(){
		int dimy = getL();
		int dimx = getH();
		noGener++;
		for(int x = 0; x < dimx; x++){
			for(int y = 0; y < dimy; y++){
				if (tabCells[x][y] && (nbVoisins(x, y) < 2 || nbVoisins(x, y) > 3))
					tabCells[x][y] = false;
				else if (nbVoisins(x, y) == 3)
					tabCells[x][y] = true;
			}
		}
	}
}
