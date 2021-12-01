package Model;

class Jogador {
	
	private static int totJog = 0;
	private final int numJog;
	private final Cor cor;
	private final Peao[] peao;
	private final byte polo;
	private byte metas, exploradores;
	
	public Jogador (Cor corJogador) {
		totJog++;
		numJog = totJog;
		cor = corJogador;
		if (cor == Cor.preto || cor == Cor.verde)
			polo = 0;
		else
			polo = 73;
		peao = new Peao[6];
		for (int i=0; i<peao.length; i++)
			peao[i] = new Peao(this, i+1);
		metas = 0;
		exploradores = 0;
	}
	
	public static int totalDeJogadores() {
		return totJog;
	}
	
	public int numeroDoJogador() {
		return numJog;
	}
	
	public Cor corDoJogador() {
		return cor;
	}
	
	public Peao retornaPeaoDoJogador(int numPeao) {
		System.out.print(numPeao);
		return peao[numPeao];
	}
	
	public Peao[] retornaListaDePeoesDoJoagdor() {
		return peao;
	}
	
	public byte poloInicialDoJogdor() {
		return polo;
	}
	
	public byte qtdMetasJogador() {
		return metas;
	}
	
	public void atingiuMetaJogador() {
		metas++;
		return;
	}
	
	public byte qtdExploradoresJogador() {
		return exploradores;
	}
	
	public void conquistouPoloOpostoJogador() {
		exploradores++;
		return;
	}
	
	public void exibeJogador() {
		System.out.printf("Jogador %d \tCor: %s \tPontos: %d\n", numJog, cor, metas+exploradores);
		return;
	}
}
