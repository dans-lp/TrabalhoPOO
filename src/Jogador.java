public class Jogador {
	
	private static int totJog = 0;
	private int numJog;
	private final String cor;
	private Peao[] peao;
	private int metas, exploradores, conquistas;
	
	public Jogador (String corJogador, int numPolo) {
		totJog++;
		numJog = totJog;
		cor = corJogador;
		peao = new Peao[6];
		for (int i=0; i<6; i++) {
			peao[i] = new Peao(numPolo, numJog, cor);
		}
		metas = 0;
		exploradores = 0;
		conquistas = 0;
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
	
	public int qtdConquistasJogador() {
		return conquistas;
	}
	
	public void conquistouPoloJogador() {
		conquistas++;
		return;
	}
	
	public void exibeJogador() {
		System.out.printf("Jogador %d \tCor: %s \tPontos: %d", numJog, cor, metas+exploradores);
		return;
	}
}