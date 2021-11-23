package Model;

public class Peao {
	
	private final int poloInicial;
	private final String cor;
	private final int jogador;
	private int polo;
	private int coordLat;
	private int coordLong;
	private int poloatual;
	
	/*
	public Peao() {
		poloInicial = 0;
		cor = null;
		jogador = 0;
		polo = 0;
		coordLat = 0;
		coordLong = 0;
	}
	*/
	
	public Peao(int numPolo, int numJogador, String corPeao){
		poloInicial = numPolo;
		cor = corPeao;
        jogador = numJogador;
        polo = poloInicial;
        coordLat = 0;
        coordLong = 0;
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
	
	public int coordenadaDoPeaoLat() {
		return coordLat;
	}
	
	public int coordenadaDoPeaoLong() {
		return coordLong;
	}
	
	public void moverPeaoLat(int coordenada) {
		coordLat = coordenada;
		return;
	}
	
	public void moverPeaoLong(int coordenada) {
		coordLong = coordenada;
		return;
	}
	
	/*
	public void exibePeao() {
		System.out.printf("Peao do jogador %d \nPolo: %d \tCoordenada: %d", jogador, polo, coord);
		return;
	}
	*/
	
	public void trocatabuleiro (int numMov, Jogador jogador, int Numpeao, int qntdecasas) {
		if (poloatual == 1) {
			poloatual = 2;
		} 
		else 
		{
			poloatual = 1;	
		}
	return;
	}
	
	int indicatabuleiro(int poloatual) {
		if(this.poloInicial == poloatual) {
			return	poloInicial;
		} 
		else {
			return poloatual;
		}	
	}
	
}