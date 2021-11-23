package Model;

class Tabuleiro {
	private Pecas coord[][];
	private Pecas polo;
	private Tabuleiro tabuleiro;
	private Tabuleiro tabuleiro2;
	private int colunas, linhas;
	public Tabuleiro() {
		linhas = 6;
		colunas = 12;
		coord = new Pecas[colunas][linhas];
		polo = new Pecas();		
		for (int i=0; i<colunas; i++)
			for (int j=0; j<linhas; j++) {
				coord[i][j] = new Pecas();
					coord[i][j].adicionaMetaNaCoord(new Meta());
			}
		coord[2][5].adicionaMetaNaCoord(new Meta());
		coord[3][4].adicionaMetaNaCoord(new Meta());
		coord[5][3].adicionaMetaNaCoord(new Meta());
		coord[8][5].adicionaMetaNaCoord(new Meta());
		coord[9][4].adicionaMetaNaCoord(new Meta());
		coord[11][3].adicionaMetaNaCoord(new Meta());
		
		
	}
	
	
	public void iniciaPolo(Jogador jogador) {
		for (int i=0; i<6; i++)
			polo.adicionaPeoesNoPolo(jogador);
		return;
	}
	
	public Pecas[][] retornacoord(){
		
		return coord;
		
	} 
	
	
	public Tabuleiro retornaTabuleiro() {	
		return this;
	}
	
	private void adicionaPeao(Jogador jogador, int numPeao, int polo, int casa) {
		coord[polo][casa].adicionaPeaoNaCoord(jogador, numPeao);
	}
	
	private void removePeca(Jogador jogador, int polo, int casa) {
		coord[polo][casa].retiraPeao(jogador);
	}
	
	
}