package Model;
import java.util.Scanner;

class Jogo {

	public static void main(String[] args) {
		Jogador jogadores[];
		Cor cor;
		Scanner ler = new Scanner(System.in);
		int qtd = 0;
		
		System.out.println("Digite a quantidade de jogadores: ");
		qtd = ler.nextInt();
		while(qtd!=2 && qtd!=4) {
			System.out.println("Quantidade de jogadores inv�lida! Tente novamente.\n\n");
			System.out.println("Digite a quantidade de jogadores: ");
			qtd = ler.nextInt();
		}
		
		jogadores = new Jogador[qtd];
		for (int i=0; i<qtd; i++) {
			System.out.printf("Digite a cor do jogador %d: ", i+1);
			cor = Cor.valueOf(ler.next());
			jogadores[i] = new Jogador(cor);
			System.out.printf("Polo do jogador %s: %s\n\n", jogadores[i].corDoJogador(), jogadores[i].poloInicialDoJogdor()==0? "Sul":"Norte");
		}
		
		if (qtd == 4) {
			System.out.println("Digite 1 para modo Duplas ou 2 para modo Competitivo: ");
			qtd = ler.nextInt();
			while(qtd!=1 && qtd!=2) {
				System.out.println("Modo inv�lido! Tente novamente!\n\n");
				System.out.println("Digite 1 para modo Duplas ou 2 para modo Competitivo: ");
				qtd = ler.nextInt();
			}
			if (qtd == 1) {
				// Chama modo Duplas
			}
			else if (qtd == 2) {
				// Chama modo Competitivo
			}
		}
		
		//Chama modo Padr�o
		return;
	}

}
