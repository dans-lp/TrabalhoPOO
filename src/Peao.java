/* OBS.: Adicionar verificação de movimento válido quando o tabuleiro estiver pronto */
public class Peao {
	
	private final int poloInicial;
	private final String cor;
	private final int jogador;
	private int polo;
	private int coord;
	
	public Peao(int numPolo, int numJogador, String corPeao){
		poloInicial = numPolo;
		cor = corPeao;
      jogador = numJogador;
      polo = poloInicial;
      coord = 0;
    }
	
	public int poloInicialDoPeao() {
		return poloInicial;
	}
	
	public String corDoPeoa() {
		return cor;
	}
	
	public int numJogadorPeao() {
		return jogador;
	}
	
	public int poloDoPeao() {
		return polo;
	}
	
	public void moverParaPoloPeao(int numPolo) {
		polo = numPolo;
		return;
	}
	
	public int coordenadaDoPeao() {
		return coord;
	}
	
	public void moverPeao(int coordenada) {
		coord = coordenada;
		return;
	}
	
	public void exibePeao() {
		System.out.printf("Peao do jogador %d \nPolo: %d \tCoordenada: %d", jogador, polo, coord);
		return;
	}
	
}