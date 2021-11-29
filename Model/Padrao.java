package Model;
import java.util.Scanner;

 class Padrao {
	
	private Tabuleiro tabuleiro;
	private Jogador[] jogadores;
	private Dados dados = new Dados();
	private int dado1, dado2;
	public int v1,v2;
	
	
	public Padrao(Jogador[] listaDeJogadores) {
		tabuleiro = new Tabuleiro();
		jogadores = new Jogador[2];
		jogadores = listaDeJogadores;
		comecarJogoPadrao();
		
	}
	
	private void comecarJogoPadrao() {
	
		int jogComeca = 0, maior = 0;
		
		
		tabuleiro.iniciaPolo(jogadores[0]);
		tabuleiro.iniciaPolo(jogadores[1]);
		System.out.println("Jogadores lancam os dados, quem obter o maior numero inicia o jogo.");
		
		for (int i=0; i<jogadores.length; i++) {
			dado1 = dados.jogaDado1();
			System.out.println("Jogador " + (i+1) + "obteve " + dado1);
			if (dado1 > maior) {
				maior = dado1;
				jogComeca = i;
			}
		}
		System.out.println("Jogador " + (jogComeca+1) + "obteve o maior numero: " + maior);
		
		this.jogoPadrao(jogComeca);
	}
	
	private void jogoPadrao(int jogDaVez) {
		boolean dadoColorido, fimDeJogo = false;
		int numPeao, movimento, numOponente;
		Cor corDado;
		Scanner ler = new Scanner(System.in);
		
		if (jogDaVez == 0) 
			numOponente = 1;	
		else 
			numOponente = 0;


		while(!fimDeJogo) {
			dado1 = dados.jogaDado1();
			dado2 = dados.jogaDado2();
			v1 = dado1;
			v2 = dado2;
			dadoColorido = dados.comparaDados();
			
			if (dadoColorido) {
				corDado = Dados.jogaDadoColorido();
				
				// * 
				if(corDado == jogadores[jogDaVez].corDoJogador()){
					ModelFacade.getNumPeao();
					Peao pJogador = jogadores[jogDaVez].retornaPeaoDoJogador(ModelFacade.getNumPeao());
					tabuleiro.movePeaoPolo(jogadores[jogDaVez], pJogador, jogadores[numOponente].poloInicialDoJogdor());
					
				}
				else if(corDado == jogadores[numOponente].corDoJogador()){
					Peao pOponente = jogadores[numOponente].retornaPeaoDoJogador(ModelFacade.getNumPeao());
					tabuleiro.movePeaoPolo(jogadores[numOponente], pOponente, jogadores[numOponente].poloInicialDoJogdor());
				}

				fimDeJogo = this.checkFimDoJogo(jogDaVez);
				continue;
			}
			// * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			
			for (int i=0; i<2; i++) {
				System.out.println("Informe o número do peão que deseja mover: ");
				numPeao = ModelFacade.getNumPeao();
				System.out.println("1 -> Latitude + \t2 -> Longitude \n");
				
				System.out.println("Em que direcao qeu deseja mover: ");
				movimento = ModelFacade.getTipoMov();
				if (i == 0)
					tabuleiro.movimentaPeao(ModelFacade.getNumPeao(), movimento, jogadores[jogDaVez].retornaPeaoDoJogador(ModelFacade.getNumPeao()+1).casaDoPeao(),ModelFacade.getCasaFinal(), dado1, jogadores[jogDaVez]);
					
					else
					tabuleiro.movimentaPeao(ModelFacade.getNumPeao(), movimento, jogadores[jogDaVez].retornaPeaoDoJogador(ModelFacade.getNumPeao()+1).casaDoPeao(),ModelFacade.getNumPeao(), dado2, jogadores[jogDaVez]);
			
				fimDeJogo = this.checkFimDoJogo(jogDaVez);
				
				if (!fimDeJogo) {
					if (jogDaVez == 0)
						jogDaVez = 1;
					else
						jogDaVez = 0;
				}
			}
		}
		this.fimDeJogoPadrao();
	}
	
	private boolean checkFimDoJogo(int numJogador) {
		if (jogadores[numJogador].qtdExploradoresJogador() == 6)
				return true;
		return false;
	}
	
	private void fimDeJogoPadrao() {
		System.out.println("Fim de Jogo! \\nContagem de pontos.."); 
		
		int j1, j2;

		j1 = jogadores[0].qtdMetasJogador() + jogadores[0].qtdExploradoresJogador();
		j2 = jogadores[1].qtdMetasJogador() + jogadores[1].qtdExploradoresJogador();
		
		jogadores[0].exibeJogador();
		jogadores[1].exibeJogador();

		if(j1 > j2)
			System.out.println("Jogador 1 ganhou o jogo!");
		else if(j2 > j1)
			System.out.println("Jogador 2 ganhou o jogo!");
		else	
			System.out.println("!!!!Empate!!!!!");			
	}
}
