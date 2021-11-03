package model;

class Pecas {
	
	private boolean coordAberta;
	private Peao[] peao;
	private Meta meta;
	
	public Pecas(){
		coordAberta = true;
		if (Jogador.totalDeJogadores() == 2)
			peao = new Peao[6];
			
		else if (Jogador.totalDeJogadores() == 4)
			peao = new Peao[12];
		
		meta = null;
	}
	
	public boolean coordenadaAberta () {
		return coordAberta;
	}
	
	private void fecharCoordenada() {
		coordAberta = false;
		return;
	}
	
	public void abreCoordenada() {
		coordAberta = true;
		return;
	}
	
	public void adicionaPeoesNoPolo(Jogador jogador) {
		peao = jogador.todosPeoesJoagdor();
	}
	
	public Peao[] peoesNaCoord() {
		return peao;
	}
	
	// Jogo Modo Padrão ou Competitivo
	public void adicionaPeaoNaCoord(Jogador jogador, int numPeao) {
		Peao p = jogador.peaodoJogador(numPeao);
		String cor = p.corDoPeoa();
		int i, qtd = 0;
		
		// Verifica se a casa tá aberta
		if (!this.coordenadaAberta()) {
			System.out.println("Casa Fechada! Tente novamente.");
			return;
		}
		
		// Posiciona o peão na casa
		for (i=0; i<peao.length; i++)
			if (peao[i] == null) {
				peao[i] = p;
				break;
			}
		
		// Verifica se tem opponente, se for o caso captura
		for (i=0; i<peao.length; i++) {
			if (peao[i] == null)
				continue;
			if (peao[i].corDoPeoa() != cor) {
				peao[i].moverParaPoloPeao(peao[i].poloInicialDoPeao());
				peao[i].moverPeao(0);
				peao[i] = null;
				jogador.capturouExploradorJogador();
			}
		}
		
		// Fecha a casa, se for o caso
		for (i=0; i<peao.length; i++) {
			if (peao[i] == null)
				continue;
			else if (peao[i].corDoPeoa() == cor) 
				qtd++;
		}
		if (qtd > 1) {
			this.fecharCoordenada();
		}
		
	}
	
	// Jogo Modo Duplas
	public void adicionaPeaoNaCoord(Jogador jogador, int numPeao, Jogador parceiro) {
		Peao p = jogador.peaodoJogador(numPeao);
		String cor = p.corDoPeoa();
		String corParceiro = parceiro.corDoJogador();
		String corAux;
		int i, qtd = 0;
			
		// Verifica se a casa tá aberta
		if (!this.coordenadaAberta()) {
			System.out.println("Casa Fechada! Tente novamente.");
			return;
		}
			
		// Posiciona o peão na casa
		for (i=0; i<peao.length; i++)
			if (peao[i] == null) {
				peao[i] = p;
				break;
			}
			
		// Verifica se tem opponente, se for o caso captura
		for (i=0; i<peao.length; i++)
			if (peao[i] == null)
				continue;
			if (peao[i].corDoPeoa() != cor) {
				peao[i].moverParaPoloPeao(peao[i].poloInicialDoPeao());
				peao[i].moverPeao(0);
				peao[i] = null;
				jogador.capturouExploradorJogador();
			}
			
		// Fecha a casa, se for o caso
		for (i=0; i<peao.length; i++) {
			if (peao[i] == null)
				continue;
			corAux = peao[i].corDoPeoa();
			if (corAux == cor || corAux == corParceiro) 
				qtd++;
		}
		if (qtd > 1)
			this.fecharCoordenada();
	}
	
	public void retiraPeao(Jogador jogador) {
		for (int i=0; i<peao.length; i++) {
			if (peao[i] == null)
				continue;
			if (peao[i].corDoPeoa() == jogador.corDoJogador())
				peao[i] = null;
		}
		return;
	}
	
	public Meta metaNaCoord() {
		return meta;
	}
	
	public void adicionaMetaNaCoord(Meta m) {
		meta = m;
		return;
	}

}
