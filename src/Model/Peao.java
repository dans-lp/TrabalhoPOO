package Model;

class Peao {
	
	private final Cor cor;
	private final Jogador jogador;
	private final int num;
	private final int poloInicial;
	private int casa;
	
	public Peao(Jogador dono, int numPeao){
		cor = dono.corDoJogador();
		jogador = dono;
		num = numPeao;
		poloInicial = dono.poloInicialDoJogdor();
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
	
	
}
