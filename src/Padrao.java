import java.util.Scanner;

public class Padrao {
	
	private Tabuleiro tabuleiro;
	private Jogador[] jogadores;
	private Dados dados;
	private int dado1, dado2;
	
	public Padrao(Jogador[] lista) {
		tabuleiro = new Tabuleiro();
		jogadores = new Jogador[2];
		jogadores = lista;
		this.comecarJogoPadrao();
	}
	
	private void comecarJogoPadrao() {
		int jogComeca = 0, maior = 0;
		
		tabuleiro.iniciaPolo(jogadores[0], jogadores[0].poloDoJogdor());
		tabuleiro.iniciaPolo(jogadores[1], jogadores[1].poloDoJogdor());
		
		System.out.println("Jogadores lan�am os dados, quem obter o maior n�mero inicia o jogo.");
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
		int numPeao, movimento;
		Scanner ler = new Scanner(System.in);
		
		while(!fimDeJogo) {
			dado1 = dados.jogaDado1();
			dado2 = dados.jogaDado2();
			dadoColorido = dados.comparaDados();
			if (dadoColorido) {
				// Chama cartas
				fimDeJogo = this.checkFimDoJogo(jogDaVez);
				continue;
			}
			for (int i=0; i<2; i++) {
				System.out.println("Informe o n�meor do pe�o qeu deseja mover: ");
				numPeao = ler.nextInt();
				System.out.println("1 -> Latitude + \t2 -> Latitude -");
				System.out.println("3 -> Longitude + \\t4 -> Longitude -");
				System.out.println("Em que dire��o qeu deseja mover: ");
				movimento = ler.nextInt();
				if (i == 0)
					tabuleiro.movimentaPeaoTabuleiro(jogadores[jogDaVez] ,numPeao, movimento, dado1 );
				else
					tabuleiro.movimentaPeaoTabuleiro(jogadores[jogDaVez], numPeao, movimento, dado2);
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
		
	}
}
