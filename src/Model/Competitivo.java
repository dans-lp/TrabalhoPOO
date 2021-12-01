package Model;
import java.util.Scanner;

class Competitivo {
	private Tabuleiro tabuleiro;
	private Jogador[] jogadores;
	private Dados dados = new Dados();
	private int dado1, dado2;
	public int v1,v2;

	
	public Competitivo(Jogador[] listaDeJogadores) {
		tabuleiro = new Tabuleiro();
		jogadores = new Jogador[4];
		jogadores = listaDeJogadores;
		comecarJogoCompetitivo();
	}
	
	private void comecarJogoCompetitivo() {
	
		int jogComeca = 0, maior = 0;
		
		
		tabuleiro.iniciaPolo(jogadores[0]);
		tabuleiro.iniciaPolo(jogadores[1]);
		tabuleiro.iniciaPolo(jogadores[2]);
		tabuleiro.iniciaPolo(jogadores[3]);
		
		System.out.println("Jogadores lancam os dados, quem obter o maior numero inicia o jogo.");
		for (int i=0; i<jogadores.length; i++) {
			System.out.println("Jogador " + (i+1) + "obteve ");
			dado1 = dados.jogaDado1();
			System.out.println("Jogador " + (i+1) + "obteve " + dado1);
			if (dado1 > maior) {
				maior = dado1;
				jogComeca = i;
			}
		}
		System.out.println("Jogador " + (jogComeca+1) + "obteve o maior numero: " + maior);
		
		this.jogoCompetitivo(jogComeca);
	}
	
	private void jogoCompetitivo(int jogDaVez) {
		boolean dadoColorido, fimDeJogo = false;
		int numPeao, movimento;
		Cor corDado;
		Scanner ler = new Scanner(System.in);
		
		while(!fimDeJogo) {
			dado1 = dados.jogaDado1();
			dado2 = dados.jogaDado2();
			v1 = dado1;
			v2 = dado2;
			dadoColorido = dados.comparaDados();
			
			if (dadoColorido) {
				corDado = Dados.jogaDadoColorido();
				
				if(corDado == jogadores[jogDaVez].corDoJogador()){
					ModelFacade.getNumPeao();
					Peao pJogador = jogadores[jogDaVez].retornaPeaoDoJogador(ModelFacade.getNumPeao());
					tabuleiro.movePeaoPolo(jogadores[jogDaVez], pJogador, jogadores[jogDaVez].poloInicialDoJogdor() == 0 ? 73: 0);
				}
				else{
					int numeropeao = ModelFacade.getNumPeao();
					Peao pOponente;
					if (numeropeao>=0 && numeropeao <6) {pOponente = jogadores[0].retornaPeaoDoJogador(numeropeao);}
					else if (numeropeao>=6 && numeropeao <12) {pOponente = jogadores[1].retornaPeaoDoJogador(numeropeao-6);}
					else if (numeropeao>=12 && numeropeao <18) {pOponente = jogadores[2].retornaPeaoDoJogador(numeropeao-12);}
					else {pOponente = jogadores[3].retornaPeaoDoJogador(numeropeao-18);}
					Jogador jOponente =  pOponente.donoDoPeao();
					if(corDado == jOponente.corDoJogador()){
						tabuleiro.movePeaoPolo(jogadores[jOponente.numeroDoJogador()], pOponente, jogadores[jOponente.numeroDoJogador()].poloInicialDoJogdor());
						
					}
				}
				
				fimDeJogo = this.checkFimDoJogo(jogDaVez);
				continue;
			}

			
			for (int i=0; i<2; i++) {
				System.out.println("Informe o número do peão que deseja mover: ");
				numPeao = ModelFacade.getNumPeao();
				System.out.println("1 -> Latitude + \t2 -> Longitude \n");
				
				System.out.println("Em que direcao qeu deseja mover: ");
				movimento = ModelFacade.getTipoMov();
				if (i == 0)
					tabuleiro.movimentaPeao(ModelFacade.getNumPeao(), movimento, jogadores[jogDaVez].retornaPeaoDoJogador(ModelFacade.getNumPeao()).casaDoPeao(),ModelFacade.getNumPeao(), dado1, jogadores[jogDaVez]);
					
					else
					tabuleiro.movimentaPeao(ModelFacade.getNumPeao(), movimento, jogadores[jogDaVez].retornaPeaoDoJogador(ModelFacade.getNumPeao()).casaDoPeao(),ModelFacade.getNumPeao(), dado2, jogadores[jogDaVez]);
			
				fimDeJogo = this.checkFimDoJogo(jogDaVez);
				
				if (!fimDeJogo) {
					if (jogDaVez != 3)
						jogDaVez += 1;
					else
						jogDaVez = 0;
				}
			}
		}
		this.fimDeJogoCompetitivo();
	}
	
	private boolean checkFimDoJogo(int numJogador) {
		if (jogadores[numJogador].qtdExploradoresJogador() == 6)
				return true;
		return false;
	}
	
	private void fimDeJogoCompetitivo() {
		System.out.println("Fim de Jogo! \\nContagem de pontos.."); 
		
		int j[] = new int[4]; 

		j[0] = jogadores[0].qtdMetasJogador() + jogadores[0].qtdExploradoresJogador();
		j[1] = jogadores[1].qtdMetasJogador() + jogadores[1].qtdExploradoresJogador();
		j[2] = jogadores[2].qtdMetasJogador() + jogadores[2].qtdExploradoresJogador();
		j[3] = jogadores[3].qtdMetasJogador() + jogadores[3].qtdExploradoresJogador();
		
		jogadores[0].exibeJogador();
		jogadores[1].exibeJogador();
		jogadores[2].exibeJogador();
		jogadores[3].exibeJogador();

		int maior = j[0];
		Jogador jVencedor = jogadores[0];
		for(int i = 1; i < 4; i++){
			if(maior < j[i]){
				jVencedor = jogadores[i];
				maior = j[i];
			}
		}
		System.out.println("Jogador" + jVencedor.corDoJogador() + "ganhou o jogo!");
       
	}
}
