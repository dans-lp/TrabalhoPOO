public class Tabuleiro {
	private Pecas coord[][];
	private int polos, casas;
	
	public Tabuleiro() {
		polos = 2;
		casas = 73;
		coord = new Pecas[polos][casas];
		for (int i=0; i<polos; i++)
			for (int j=0; j<casas; j++) {
				coord[i][j] = new Pecas();
				if (j==42 || j==48 || j==52 || j==58 || j==63 || j== 69)
					coord[i][j].posicionaMetaNaCoord(new Meta());
			}
	}
	
	public void adicionaPeca(int lado, int casa) {
		
	}
	
	public void removePeca(int lado, int casa) {

	}

}
