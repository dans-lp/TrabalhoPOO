package model;

class Tabuleiro {
	private Pecas coord[][];
	private Pecas polo[];
	private int colunas, linhas;
	private String hemisferio;
	
	public Tabuleiro() {
		linhas = 6;
		colunas = 12;
		coord = new Pecas[colunas][linhas];
		polo = new Pecas[7];
		
		for (int i=0; i<colunas; i++)
			for (int j=0; j<linhas; j++) {
				coord[i][j] = new Pecas();
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
