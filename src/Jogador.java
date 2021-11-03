package model;

class Jogador {
	
	private static int totJog = 0;
	private int numJog;
	private final String cor;
	private Peao[] peao;
	private int polo, metas, exploradores;
	
	public Jogador (String corJogador, int numPolo) {
		totJog++;
		numJog = totJog;
		cor = corJogador;
		polo = numPolo;
		peao = new Peao[6];
		for (int i=0; i<peao.length; i++) {
			peao[i] = new Peao(polo, numJog, cor);
		}
		metas = 0;
		exploradores = 0;
	}
	
	public static int totalDeJogadores() {
		return totJog;
	}
	
	public int numeroDoJogador() {
		return numJog;
	}
	
	public String corDoJogador() {
		return cor;
	}
	
	public Peao peaodoJogador(int numPeao) {
		return peao[numPeao-1];
	}
	
	public Peao[] todosPeoesJoagdor() {
		return peao;
	}
	
	public int poloDoJogdor() {
		return polo;
	}
	
	public int qtdMetasJogador() {
		return metas;
	}
	
	public void atingiuMetaJogador() {
		metas++;
		return;
	}
	
	public int qtdExploradoresJogador() {
		return exploradores;
	}
	
	public void capturouExploradorJogador() {
		exploradores++;
		return;
	}
	
	public void exibeJogador() {
		System.out.printf("Jogador %d \tCor: %s \tPontos: %d", numJog, cor, metas+exploradores);
		return;
	}
}
