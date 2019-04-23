public enum Terrain {
	Sol, Dresseur, DresseurVaincu, Rocher, Eau, Herbe, PorteCentrePokemon, CentrePokemon,
	Toit1CentrePokemon, Toit2CentrePokemon, Toit3CentrePokemon, PontEau, PontSol;
	
	public final static int convValue[] = 	{1 ,2, 3, 4, 5, 6, 7, 8,
											9, 10, 11, 12, 13};
	
	public static Terrain conv(int value){
		return Terrain.values()[value-1];
    }
	
}
