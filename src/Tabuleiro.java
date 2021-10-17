
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
					coord[i][j].adicionaMetaNaCoord(new Meta());
			}
	}
	
	public void iniciaPolo(Jogador jogador, int polo) {
		coord[polo][0].adicionaPeoesNoPolo(jogador);
		return;
	}
	
	private void adicionaPeao(Jogador jogador, int numPeao, int polo, int casa) {
		coord[polo][casa].adicionaPeaoNaCoord(jogador, numPeao);
	}
	
	private void removePeca(Jogador jogador, int polo, int casa) {
		coord[polo][casa].retiraPeao(jogador);
	}
	
	public void movimentaPeaoTabuleiro(Jogador jogador, int numPeao, int movimento, int qtdCasas) {
		
	}

}
