package Model;

class Pecas {
	
	private boolean casaFechada;
	private Peao[] peoes;
	private byte qtdPeoes;
	private Meta meta;
	
	public Pecas(){
		casaFechada = false;
		if (Jogador.totalDeJogadores() == 2)
			peoes = new Peao[6];
			
		else if (Jogador.totalDeJogadores() == 4)
			peoes = new Peao[12];
		qtdPeoes = 0;
		meta = null;
	}
	
	// Jogo Modo Padrão ou Competitivo
	public boolean casaFechada (Jogador jogador) {
		if (casaFechada && peoes[0].corDoPeao() == jogador.corDoJogador())
			return false;
		return casaFechada;
	}
	
	// Jogo Modo Duplas
	public boolean casaFechada (Jogador jogador, Jogador parceiro) {
		Cor corJog = jogador.corDoJogador();
		Cor corPar = parceiro.corDoJogador();
		Cor corCasa = peoes[0].corDoPeao();
		
		if (casaFechada && (corCasa == corJog || corCasa == corPar))
			return false;
		return casaFechada;
	}
	
	private void fecharCasa() {
		casaFechada = true;
		return;
	}
	
	private void abrirCasa() {
		casaFechada = true;
		return;
	}
	
	public void adicionaMetaNaCasa(Meta m) {
		meta = m;
		return;
	}
	
	public boolean temMetaNaCasa() {
		if (meta != null)
			return meta.metaDisponivel();
		return false;
	}
	
	public void MetaAtingida(Jogador jogador) {
		meta.atingiuMeta();
		jogador.atingiuMetaJogador();
	}
	
	public Peao[] retornaListaDePeoesNaCasa() {
		return peoes;
	}
	
	public void inicioPeoesNoPolo(Jogador jogador) {
		peoes = jogador.retornaListaDePeoesDoJoagdor();
		qtdPeoes+=6;
	}
	
	// Jogo Modo Padrão ou Competitivo
	// Se um peao adversario foi capturado, retorna o peao, caso contrario ret null
	public Peao posicionaPeaoNaCasa(Jogador jogador, int numPeao) {
		Peao p = jogador.retornaPeaoDoJogador(numPeao);
		Peao pAdv = null;
		Cor cor = p.corDoPeao();
		byte qtd = 0;

		// Posiciona o peão na casa
		peoes[qtdPeoes] = p;
		qtdPeoes++;
		
		// Verifica se tem opponente, se for o caso captura
		for (int i=0; i<qtdPeoes; i++) {
			pAdv = peoes[i];
			if (pAdv.corDoPeao() != cor) {
				for (int j=i; peoes[j]!=null; j++)
					peoes[j] = peoes[j+1];
				break;
			}
		}
		
		// Fecha a casa, se for o caso
		if (qtdPeoes > 1) {
			for (int i=0; i<qtdPeoes; i++)
				if (cor == peoes[i].corDoPeao())
					qtd++;

			if (qtd > 1)
				fecharCasa();
			
			if (temMetaNaCasa()){
				MetaAtingida(jogador);
				return p;
			}
			
		}
		return pAdv;
	}
	
	// Jogo Modo Duplas
	// Se um peao adversario foi capturado, retorna o peao, caso contrario ret null
	public Peao posicionaPeaoNaCasa(Jogador jogador, int numPeao, Jogador parceiro) {
		Peao p = jogador.retornaPeaoDoJogador(numPeao);
		Peao pAdv = null;
		Cor cor = p.corDoPeao();
		Cor corParceiro = parceiro.corDoJogador();
		Cor corAux;
		int qtd = 0;
		
		// Posiciona o peão na casa
		peoes[qtdPeoes] = p;
		qtdPeoes++;
		
		// Verifica se tem opponente, se for o caso captura
		for (int i=0; i<qtdPeoes; i++) {
			pAdv = peoes[i];
			corAux = pAdv.corDoPeao(); 
			if (corAux != cor && corAux != corParceiro) {
				for (int j=i; peoes[j]!=null; j++)
				peoes[j] = peoes[j+1];
				break;
			}
		}
		
		// Fecha a casa, se for o caso
		if (qtdPeoes > 1) {
			for (int i=0; i<qtdPeoes; i++) {
				corAux = peoes[i].corDoPeao();
				if (corAux == cor || corAux == corParceiro) 
				qtd++;
			}
			
			if (qtd > 1)
			fecharCasa();
			
			if (temMetaNaCasa()){
				qtd = 0;
				for (int i=0; i<qtdPeoes; i++) {
					corAux = peoes[i].corDoPeao();
					if (corAux == cor) 
					qtd++;
				}
				
				if(qtd > 1){
					MetaAtingida(jogador);	
					return p;
				}
			}
		}
		return pAdv;
	}
	
	// Jogo Modo Padrão ou Competitivo
	public Peao retiraPeao(int numPeao, Jogador jogador) {
		Peao pAux = null;
		Cor corJog = jogador.corDoJogador();
		byte qtd = 0;
		
		// Retira o peao da casa
		for (int i=qtdPeoes-1; i>=0; i--) {
			pAux = peoes[i];
			if (pAux.corDoPeao() == corJog && pAux.numeroDoPeao() == numPeao) {
				for (int j=i; peoes[j]!=null; j++)
					peoes[j] = peoes[j+1];
				break;
			}
		}
		qtdPeoes--;
		
		// Abre a casa, se for o caso
		if (qtdPeoes > 1) {
			for (int i=0; i<qtdPeoes; i++)
				if (corJog == peoes[i].corDoPeao())
					qtd++;
			if (qtd < 2)
				abrirCasa();
		}
		
		return pAux;
	}
	
	// Jogo Modo Duplas
	public Peao retiraPeao(int numPeao, Jogador jogador, Jogador parceiro) {
		Peao pAux = null;
		Cor corJog = jogador.corDoJogador();
		Cor corParceiro = parceiro.corDoJogador();
		int qtd = 0;
		
		// Retira o peao da casa
		for (int i=qtdPeoes-1; i>=0; i--) {
			pAux = peoes[i];
			if (pAux.corDoPeao() == corJog && pAux.numeroDoPeao() == numPeao) {
				for (int j=i; peoes[j]!=null; j++)
					peoes[j] = peoes[j+1];
				break;
			}
		}
		qtdPeoes--;
		
		// Abre a casa, se for o caso
		if (qtdPeoes > 1) {
			for (int i=0; i<qtdPeoes; i++) {
				Cor corPeao = peoes[i].corDoPeao();
				if (corJog == corPeao || corParceiro == corPeao)
					qtd++;
			}
			if (qtd < 2)
				abrirCasa();
		}
		return pAux;
	}

	public void posicionaPeaoPoloIni(Peao p){
		peoes[qtdPeoes] = p;
		qtdPeoes++;
	}

}
