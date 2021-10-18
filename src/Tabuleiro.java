import java.util.SortedMap;

import javax.lang.model.util.ElementScanner14;
import javax.naming.LimitExceededException;

public class Tabuleiro {
	private Pecas coord[][];
	private int polos, casas;
	
	public Tabuleiro() {
		polos = 2;
		casas = 73;
		coord = new Pecas[polos][casas];
		
		for (int i=0; i<polos; i++)
			for (int j=0; j<casas; j++) {
				coord[i][j] = new Pecas();
				if (j==42 || j==48 || j==52 || j==58 || j==63 || j== 69)
					coord[i][j].adicionaMetaNaCoord(new Meta());
			}
	}
	
	public void iniciaPolo(Jogador jogador, int polo) {
		coord[polo][0].adicionaPeoesNoPolo(jogador);
		return;
	}
	
	private void adicionaPeao(Jogador jogador, int numPeao, int polo, int casa) {
		coord[polo][casa].adicionaPeaoNaCoord(jogador, numPeao);
	}
	

	private void removePeca(Jogador jogador, int polo, int casa) {
		coord[polo][casa].retiraPeao(jogador);
	}
	

	private void movimentaLatitude(int qtdCasas, Jogador jogador, int numPeao){
		
		Peao peaoJ = new Peao();
		int coordP;
		
		peaoJ = jogador.peaodoJogador(numPeao);
		coordP = peaoJ.coordenadaDoPeao();
		
		int mul = (qtdCasas * 12) + coordP;
		
		if(coordP > 72)
		{ 
			if (coordP == 73 || coordP == 74 || coordP == 79 || coordP == 80 ) 
			{
				if(peaoJ.poloDoPeao() == 1) { peaoJ.moverParaPoloPeao(0);}
				
				else { peaoJ.moverParaPoloPeao(1); }

				mul = -(qtdCasas * 12) + coordP;

				this.coord[peaoJ.poloDoPeao()][peaoJ.coordenadaDoPeao()].adicionaPeaoNaCoord(jogador, numPeao);
				peaoJ.moverPeao(mul);
			}
		 }

		return;
	}

	private void movimentaLongitude(int qtdCasas, Jogador jogador, int numPeao){
		Peao peaoJ = new Peao();
		int coordP;
		int soma;
		int limite;
		peaoJ = jogador.peaodoJogador(numPeao);
		coordP = peaoJ.coordenadaDoPeao();
		
		soma = coordP + qtdCasas;
		limite = (coordP/12) + 1;
		limite *=  12;

		if(soma > limite ) { soma -=  limite; }
		
		peaoJ.moverPeao(soma);

		
		this.coord[peaoJ.poloDoPeao()][peaoJ.coordenadaDoPeao()].adicionaPeaoNaCoord(jogador, numPeao);

		return;
	}

	public void movimentaPeaoTabuleiro(Jogador jogador, int numPeao, int movimento, int qtdCasas) {
		if(movimento <= 2  )
		{
			
			if(movimento == 2){ movimentaLatitude(-qtdCasas, jogador, numPeao); }
			
			else{ movimentaLatitude(qtdCasas, jogador, numPeao); }
		}
		else 
		{
			if (movimento == 4) { movimentaLongitude(-qtdCasas, jogador, numPeao); }

			else { movimentaLongitude(qtdCasas, jogador, numPeao); }
		}
	}

}
