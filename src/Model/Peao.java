package model;

public class Peao {
	
	private final Cor cor;
	private final Jogador jogador;
	private final int num;
	private final int poloInicial;
	/*private final byte poloOposto;
	private byte poloAtual;*/
	private int casa;
	
	public Peao(Jogador dono, int numPeao){
		cor = dono.corDoJogador();
		jogador = dono;
		num = numPeao;
		poloInicial = dono.poloInicialDoJogdor();
		/*poloAtual = casa = poloInicial;
		if (poloInicial == 0) 
			poloOposto = 73;
		else 
			poloOposto = 0;*/
    }
	
	public Cor corDoPeao() {
		return cor;
	}
	
	public Jogador donoDoPeao() {
		return jogador;
	}
	
	public int numeroDoPeao() {
		return num;
	}
	
	public int poloInicialDoPeao() {
		return poloInicial;
	}
	
	/*public byte poloOpostoDoPeao() {
		return poloOposto;
	}
	
	public byte poloAtualDoPeao() {
		return poloAtual;
	}
	
	public void trocaDePolo() {
		if (poloAtual == 0) 
			poloAtual = 73;
		else 
			poloAtual = 0;
		return;
	}*/
	
	public int casaDoPeao() {
		return casa;
	}
	
	public void mudarCasaDoPeao(int novaCasa) {
		casa = novaCasa;
		return;
	}
	
	public void exibePeao() {
		System.out.printf("Peao do jogador %d \nPolo: %d \tCasa: %d\n", jogador.numeroDoJogador(), poloInicial, casa);
		return;
	}
	
	/*public void trocatabuleiro (int numMov, Jogador jogador, int Numpeao, int qntdecasas) {
		if (poloatual== 1) {
			poloatual = 2;
		} else {
			poloatual =1 ;
		
	}
	return;
}
	public void indicatabuleiro(int poloatual) {
		if(poloatual == 1) {
			//tabuleiro1;
			
		} else {
			//tabuleiro2;
		}
	}*/
	
}
