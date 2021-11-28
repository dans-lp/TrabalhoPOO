package Model;

public class ModelFacade {
	private static ModelFacade modFac = null;
	private Padrao modoPadrao;
	private Competitivo modoComp;
	private Duplas modoDuplas;
	private Jogador jogadores[];
	
	private ModelFacade() {}
	
	public static ModelFacade getModelFacade () {
		if (modFac == null)
			modFac = new ModelFacade();
		return modFac;
	}
	
	public void ComecaJogoModel (int modoJogo) {
		switch (modoJogo) {
		case 1:
			jogadores = new Jogador[2];
			jogadores[0] = new Jogador(Cor.preto);
			jogadores[1] = new Jogador(Cor.azul);
			modoPadrao = new Padrao(jogadores);
			break;
		case 2:
			jogadores = new Jogador[4];
			jogadores[0] = new Jogador(Cor.preto);
			jogadores[1] = new Jogador(Cor.verde);
			jogadores[2] = new Jogador(Cor.azul);
			jogadores[3] = new Jogador(Cor.amarelo);
			modoComp = new Competitivo(jogadores);
			break;
		case 3:
			jogadores = new Jogador[4];
			jogadores[0] = new Jogador(Cor.preto);
			jogadores[1] = new Jogador(Cor.verde);
			jogadores[2] = new Jogador(Cor.azul);
			jogadores[3] = new Jogador(Cor.amarelo);
			modoDuplas = new Duplas(jogadores);
			break;
		default:
			System.out.println("Modo de jogo invalido.\n\n");
		}	
	}
	
	public Padrao getModoPadrao() {
		return modoPadrao;
	}
	
	public Competitivo getModoCompetitivo() {
		return modoComp;
	}
	
	public Duplas getModoDuplas() {
		return modoDuplas;
	}
	
	public Jogador[] getJogadores() {
		return jogadores;
	}
}
