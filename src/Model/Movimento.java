package Model;

public class Movimento {
	private Pecas coord[][];
	private Pecas coordOposto[][];
	private  Tabuleiro tab;
	private  Tabuleiro tab3;

	
	
	public Movimento(Tabuleiro tabatual, Tabuleiro tabOposto) {

	coordOposto = tabOposto.retornacoord();
	coord = tabatual.retornacoord();
	
	
	}
	
	private void movimentaLatitudeFrente(int qtdCasas, Jogador jogador, int numPeao,Tabuleiro tabatual, Tabuleiro tabOposto, int coordLat , int coordLong, Peao peaoJ, int total){
		
		
		if(total< 6){
			
			for(int i=coordLat; i<total;i++) {
				
				if(coord[coordLong][i].coordenadaAberta())
				{
					continue;
				}
				else
				{
					System.out.print("A casa não esta aberta");				
					return;
				}
			}
			
			coord[coordLong][coordLat].retiraPeao(jogador);
			coord[coordLong][total].adicionaPeaoNaCoord(jogador, numPeao);
			peaoJ.moverPeaoLat(total);
			
		}	
		else if(coordLong == 0 || coordLong == 1 || coordLong == 6 || coordLong == 7 )  {
			
			for(int i=coordLat; i<=5;i++){
				
				if(coord[coordLong][i].coordenadaAberta()) 
				{	
					continue;
				}
				else
				{
					System.out.print("A casa não esta aberta");				
					return;
				}
			}
			
			int falta;
			coordOposto = tabatual.retornacoord();
			coord = tabOposto.retornacoord();
			falta = qtdCasas - (5-coordLat);
			
			switch (coordLong) {
				case 0:
				coordLong = 7;
				break;
				
				case 1:
				coordLong = 6;
				break;
				
				case 6:
				coordLong = 1;
				break;
				
				case 7:
				coordLong = 0;
				break;
				
				default:
				break;
			}
			
			
			for(int i = 5, j = falta; j > 0; i--, j--){
				
				if(coord[coordLong][i].coordenadaAberta()) 
				{	
					continue;
				}
				else
				{
					System.out.print("A casa não esta aberta");				
					return;
				}
			}
			
			coordOposto[peaoJ.coordenadaDoPeaoLong()][coordLat].retiraPeao(jogador);
			coord[coordLong][5 - falta].adicionaPeaoNaCoord(jogador, numPeao);
			peaoJ.moverPeaoLong(5 - falta);
			
			
			
		}
	}
	
	
	
	
	
	private void movimentaLatitudeTras(int qtdCasas, Jogador jogador, int numPeao,Tabuleiro tabatual, Tabuleiro tabOposto, int coordLat , int coordLong, Peao peaoJ, int total, int falta){
		
		if(total >= 0){
			
			for(int i = coordLat; i > total; i--) {
				
				if(coord[coordLong][i].coordenadaAberta())
				{
					continue;
				}
				else
				{
					System.out.print("A casa não esta aberta");				
					return;
				}
			}
			
			coord[coordLong][coordLat].retiraPeao(jogador);
			coord[coordLong][total].adicionaPeaoNaCoord(jogador, numPeao);
			peaoJ.moverPeaoLat(total);
			
		}	
		else if(coordLong == 0 || coordLong == 1 || coordLong == 6 || coordLong == 7 ){
			
			for(int i=coordLat; i<=5;i++){
				
				if(coord[coordLong][i].coordenadaAberta()) 
				{	
					continue;
				}
				else
				{
					System.out.print("A casa não esta aberta");				
					return;
				}
			}
			
			coordOposto = tabatual.retornacoord();
			coord = tabOposto.retornacoord();
			switch (coordLong) {
				case 0:
				coordLong = 7;
				break;
				
				case 1:
				coordLong = 6;
				break;
				
				case 6:
				coordLong = 1;
				break;
				
				case 7:
				coordLong = 0;
				break;
				
				default:
				break;
			}
			
			
			for(int i = 5, j = falta; j > 0; i--, j--){
				
				if(coord[coordLong][i].coordenadaAberta()) 
				{	
					continue;
				}
				else
				{
					System.out.print("A casa não esta aberta");				
					return;
				}
			}
			
			coordOposto[peaoJ.coordenadaDoPeaoLong()][coordLat].retiraPeao(jogador);
			coord[coordLong][5 - falta].adicionaPeaoNaCoord(jogador, numPeao);
			peaoJ.moverPeaoLong(5 - falta);
			
		}
		
	}
	
	
	private void movimentaLongitudeFrente();
	private void movimentaLongitudeTras();
	
	private void trocatabuleiro(){
		
		
	}
	
	
	
	private void movimentaLatitude(int qtdCasas, Jogador jogador, int numPeao, int numMov,Tabuleiro tabatual, Tabuleiro tabOposto){
		
		Peao peaoJ;
		int coordLat;
		int coordLong;
		
		peaoJ = jogador.peaodoJogador(numPeao);
		coordLat = peaoJ.coordenadaDoPeaoLat();
		coordLong = peaoJ.coordenadaDoPeaoLong();
		
		int falta;
		falta = qtdCasas - (5-coordLat);
		
		int total;
		if(numMov == 1 )
		{ // MOV 1 = Latitude para frente.
			total = qtdCasas + coordLat;
			if(total > 5 ){
				movimentaLatitudeFrente(5 - coordLat, jogador, numPeao, tabatual, tabOposto, coordLat, coordLong, peaoJ, total);
				
				
				movimentaLatitudeTras(qtdCasas - (5 - coordLat), jogador, numPeao, tabatual, tabOposto, coordLat, coordLong, peaoJ, total, falta);	
			}
			
		}
		else if(numMov == 2) //movimento latitude para trás
		{
			total  = coordLat - qtdCasas;
			movimentaLatitudeTras(qtdCasas, jogador, numPeao, tabatual, tabOposto, coordLat, coordLong, peaoJ, total, falta);
		}
		
		
		
	}
	
}



//return;


/*private void movimentaLongitude(int qtdCasas, Jogador jogador, int numPeao){
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
*/