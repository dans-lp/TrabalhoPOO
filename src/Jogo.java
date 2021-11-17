package model;
import java.util.Scanner;

class Jogo {

	public static void main(String[] args) {
		
		Jogador jogadores[];
		String cores[] = {"preto", "azul","amarelo", "verde"};
		Scanner ler = new Scanner(System.in);
		int qtd;
		
		while(true) {
			System.out.println("Digite a quantidade de jogadores: ");
			qtd = ler.nextInt();
			if (qtd == 2 || qtd == 4)
				break;
			System.out.println("Quantidade de jogadores inválida! Tente novamente.");
		}
		
		jogadores = new Jogador[qtd];
		for (int i=0; i<qtd; i++) {
			jogadores[i] = new Jogador(cores[i], i%2);
			System.out.printf("Polo do jogador %d: %d\n", jogadores[i].numeroDoJogador(), jogadores[i].peaodoJogador(1).poloDoPeao());
		}
		
		if (qtd == 4) {
			while(true) {
				System.out.println("Digite 1 para modo Duplas ou 2 para modo Competitivo: ");
				qtd = ler.nextInt();
				if (qtd == 1) {
					// Chama modo Duplas
					break;
				}
				else if (qtd == 2) {
					// Chama modo Competitivo
					break;
				}
				System.out.println("Modo inválido! Tente novamente!");
			}
		}
		
		//Chama modo Padrão
		return;
	}

}
