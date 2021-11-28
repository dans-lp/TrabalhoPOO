package Model;

class Dados {
	
	private static int dado1;
	private static int dado2;
	private static int total;
	
	

	
	public int jogaDado1() {
		double aleatorio1 = Math.random();
		dado1 = (int) (1 +  aleatorio1 * (6-1));
		return dado1;
	}
	public int jogaDado2() {
		double aleatorio2 = Math.random();
		dado2 = (int) (1 +  aleatorio2 * (6-1));
		return dado2;
	}

	public int SomaDados() {
		total = dado1 + dado2;
		return total;
	}


	public static Cor jogaDadoColorido(){
		int nCor;
		nCor = (int) (Math.random() * 4);
		System.out.println("!!!!! TESTE COR: "+ nCor);
		return Cor.values()[nCor];
	}



	public boolean comparaDados() {
	
		System.out.println("O valor do Primeiro dado �: "+ dado1);
		System.out.println("O valor do Segundo dado �: "+ dado2);
		
		if(dado1 == dado2) {
			System.out.println("Números repetidos!");
		
			return true;
		}
		else {
			System.out.println("O valor de casas a ser andado � de: "+ SomaDados());
			return false;
		}
	}
}
