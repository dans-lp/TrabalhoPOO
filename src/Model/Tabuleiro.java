package Model;

class Tabuleiro {
	private final int TAM = 146; // total de casas tabuleiro
	private final int MET = 73; //qtd casas cada lado 
	private Pecas casa[] = new Pecas[TAM]; // proprio tabuleiro
	private byte conexoesLat[][] = new byte[TAM][TAM]; //grafo latitude 
	private byte conexoesLon[][] = new byte[TAM][TAM]; // gafro longitude
	
	public Tabuleiro() {		
		for (int i=0; i<TAM; i++) {
			casa[i] = new Pecas();
			for (int j=0; j<TAM; j++) {
				conexoesLat[i][j] = 0;
				conexoesLon[i][j] = 0;
			}
		}
		
		casa[42].adicionaMetaNaCasa(new Meta());
		casa[42+MET].adicionaMetaNaCasa(new Meta());
		casa[48].adicionaMetaNaCasa(new Meta());
		casa[48+MET].adicionaMetaNaCasa(new Meta());
		casa[52].adicionaMetaNaCasa(new Meta());
		casa[52+MET].adicionaMetaNaCasa(new Meta());
		casa[58].adicionaMetaNaCasa(new Meta());
		casa[58+MET].adicionaMetaNaCasa(new Meta());
		casa[63].adicionaMetaNaCasa(new Meta());
		casa[63+MET].adicionaMetaNaCasa(new Meta());
		casa[69].adicionaMetaNaCasa(new Meta());
		casa[69+MET].adicionaMetaNaCasa(new Meta());
		
		conectaLat();
		conectaLon();
	}
	
	
	public void iniciaPolo(Jogador jogador) {
		casa[jogador.poloInicialDoJogdor()].inicioPeoesNoPolo(jogador);
		return;
	}
	
	public Pecas[] retornaCasas(){
		return casa;
	}
	
	public void movePeaoPolo(Jogador jogador, Peao Pjogador, int polo){
		casa[polo].posicionaPeaoPoloIni(Pjogador);
			if(polo != Pjogador.poloInicialDoPeao())
				jogador.conquistouPoloOpostoJogador();
	}

	// Jogo Modo Padrão ou Competitivo
	private void trocaCasa(int numPeao, int casaIni, int casaFin, Jogador jogador ){
		Peao Pjogador = casa[casaIni].retiraPeao(numPeao, jogador);
		Peao Poponente;
		
		String cs;
		
		if(casaFin == 0 || casaFin == 73){
			trocaCasa(numPeao, casaIni, casaFin, jogador);
		}
		else {
			Poponente = casa[casaFin].posicionaPeaoNaCasa(jogador, numPeao);
			
			
			if(Poponente != null){
				if(Poponente.donoDoPeao() != jogador){
					casa[Poponente.poloInicialDoPeao()].posicionaPeaoPoloIni(Poponente);
					Poponente.mudarCasaDoPeao(Poponente.poloInicialDoPeao());
				}
				else{
					cs = Carta.SorteiaCarta();
					
					if(cs == "C04.png"){
						for(int i = 0; i < 6; i++){
							if(jogador.retornaPeaoDoJogador(i).casaDoPeao() == jogador.poloInicialDoJogdor())		
								movimentaPeao(numPeao, 1, casaIni, casaFin, 3, jogador);

						}
					}
					else if(cs == "C15.png"){
						for(int i = 0; i < 6; i++){
							if(jogador.retornaPeaoDoJogador(i).casaDoPeao() == jogador.poloInicialDoJogdor()){

								movePeaoPolo(jogador, Pjogador, Poponente.poloInicialDoPeao());
							}		
							
						}
						
					}
				}
			}
		}
		Pjogador.mudarCasaDoPeao(casaFin);
	}

	// Jogo Modo Duplas
	private void trocaCasa(int numPeao, int casaIni, int casaFin, Jogador jogador, Jogador parceiro){
		Peao Pjogador = casa[casaIni].retiraPeao(numPeao, jogador, parceiro);
		Peao Poponente;
		
		if(casaFin == 0 || casaFin == 73){
			movePeaoPolo(jogador, Pjogador, casaFin);
		}
		else {
			Poponente = casa[casaFin].posicionaPeaoNaCasa(jogador, numPeao);
			if(Poponente != null){
				casa[Poponente.poloInicialDoPeao()].posicionaPeaoPoloIni(Poponente);
				Poponente.mudarCasaDoPeao(Poponente.poloInicialDoPeao());
			}
		}
		Pjogador.mudarCasaDoPeao(casaFin);
	}

	// Jogo Modo Padrão ou Competitivo
	public boolean movimentaPeao(int numPeao, int tipoMov, int casaIni, int casaFin, int qtdCasas, Jogador jogador) {
		boolean podeMover = false;
		
		if(tipoMov == 1){
			podeMover = procuraCaminhoLatitude(casaIni, casaFin, qtdCasas, jogador);
			trocaCasa(numPeao, casaIni, casaFin, jogador);
				
		}
		else if(tipoMov == 2){
			podeMover = procuraCaminhoLongitude(casaIni, casaFin, qtdCasas, jogador);
			trocaCasa(numPeao, casaIni, casaFin, jogador);
		}
		return podeMover;
	}
	
	// Jogo Modo Duplas
		public boolean movimentaPeao(int numPeao, int tipoMov, int casaIni, int casaFin, int qtdCasas, Jogador jogador, Jogador parceiro) {
			boolean podeMover = false;
			
			if(tipoMov == 1){
				podeMover = procuraCaminhoLatitude(casaIni, casaFin, qtdCasas, jogador, parceiro);
				trocaCasa(numPeao, casaIni, casaFin, jogador, parceiro);
					
			}
			else if(tipoMov == 2){
				podeMover = procuraCaminhoLongitude(casaIni, casaFin, qtdCasas, jogador, parceiro);
				trocaCasa(numPeao, casaIni, casaFin, jogador, parceiro);
			}
			return podeMover;
		}
	
	private void conectaLat() {
		// Conecta o polo com todas as casas a sua volta
		for (int i=1; i<13; i++) {
			// Lado esquerdo
			conexoesLat[0][i] = 1;
			conexoesLat[i][0] = 1;
			conexoesLat[i][i+12] = 1;
			// Lado direito
			conexoesLat[73][i+73] = 1;
			conexoesLat[i+73][73] = 1;
			conexoesLat[i+73][i+73+12] = 1;
		}
		// Conecta cada casa com a latitude da frente e de trás. 
		for (int i=13; i<73; i++) {
			conexoesLat[i][i-12] = 1;
			conexoesLat[i+73][i+73-12] = 1;
			if (i < 61) {
				conexoesLat[i][i+12] = 1;
				conexoesLat[i+73][i+73+12] = 1;
			}
		}
		// Conecta os dois lados do tabuleiro
		conexoesLat[61][73+68] = 1;
		conexoesLat[73+68][61] = 1;
		conexoesLat[62][73+67] = 1;
		conexoesLat[73+67][62] = 1;
		conexoesLat[67][73+62] = 1;
		conexoesLat[73+62][67] = 1;
		conexoesLat[68][73+61] = 1;
		conexoesLat[73+61][68] = 1;
	}
	
	private void conectaLon() {
		for(int i=2; i<73; i++) {
			if (i%12 == 1)
				continue;
			// Lado esquerdo
			conexoesLon[i-1][i] = 1;
			conexoesLon[i][i-1] = 1;
			// Lado direito
			conexoesLon[i+73-1][i+73] = 1;
			conexoesLon[i+73][i+73-1] = 1;
		}
		for(int i=1; i<62; i+=12) {
			// Lado esquerdo
			conexoesLon[i][i+11] = 1;
			conexoesLon[i+11][i] = 1;
			// Lado direito
			conexoesLon[i+73][i+73+11] = 1;
			conexoesLon[i+73+11][i+73] = 1;
		}
	}
	
	private boolean adjacenteLatitude(int casa1, int casa2) {
	    if (conexoesLat[casa1][casa2] == 1)
	        return true;
	    else return false;
	}
	
	private boolean adjacenteLongitude(int casa1, int casa2) {
	    if (conexoesLon[casa1][casa2] == 1)
	        return true;
	    else return false;
	}
	
	// Jogo Modo Padrão ou Competitivo
	private boolean procuraCaminhoLatitude(int casa1, int casa2, int k, Jogador jogador) {
	    int c;
	    if (k == 0)
	    	return false;
	    if (k == 1) {
	        if (adjacenteLatitude(casa1, casa2))
	            if(!casa[casa2].casaFechada(jogador)) {
	            	return true;
	            }
	        else return false;
	    }
	    for (c=0; c<TAM; c++) {
	        if (adjacenteLatitude(casa1, c) && procuraCaminhoLatitude(c, casa2, k-1, jogador))
	            return true;
	    }
	    return false;
	}
	
	// Jogo Modo Duplas
	private boolean procuraCaminhoLatitude(int casa1, int casa2, int k, Jogador jogador, Jogador parceiro) {
	    int c;
	    if (k == 0)
	    	return false;
	    if (k ==1) {
	        if (adjacenteLatitude(casa1, casa2))
	            if(casa[casa2].casaFechada(jogador, parceiro)) {
	            	return true;
	            }
	        else return false;
	    }
	    for (c=0; c<TAM; c++)
	        if (adjacenteLatitude(casa1, c) && procuraCaminhoLatitude(c, casa2, k-1, jogador, parceiro))
	            return true;
	    return false;
	}
	
	// Jogo Modo Padrão ou Competitivo
	private boolean procuraCaminhoLongitude(int casa1, int casa2, int k, Jogador jogador) {
	    int c;
	    if (k == 0)
	    	return false;
	    if (k ==1) {
	        if (adjacenteLongitude(casa1, casa2)) {
	            if (!casa[casa2].casaFechada(jogador))
	            	return true;
	        }    
	        else return false;
	    }
	    for (c=0; c<TAM; c++)
	        if (adjacenteLongitude(casa1, c) && procuraCaminhoLongitude(c, casa2, k-1, jogador))
	            return true;
	    return false;
	}

	// Jogo Modo Duplas
	private boolean procuraCaminhoLongitude(int casa1, int casa2, int k, Jogador jogador, Jogador parceiro) {
	    int c;
	    if (k == 0)
	    	return false;
	    if (k ==1) {
	        if (adjacenteLongitude(casa1, casa2)) {
	            if (!casa[casa2].casaFechada(jogador, parceiro))
	            	return true;
	        }    
	        else return false;
	    }
	    for (c=0; c<TAM; c++)
	        if (adjacenteLongitude(casa1, c) && procuraCaminhoLongitude(c, casa2, k-1, jogador, parceiro))
	            return true;
	    return false;
	}
}