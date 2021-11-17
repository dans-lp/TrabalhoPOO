package model;

class Dados {
	
	private static int dado1;
	private static int dado2;
	private static int total;
	private static String cores[] = {"preto","verde","amarelo", "azul"};

	
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


	public boolean comparaDados() {
	
		System.out.println("O valor do Primeiro dado é: "+ dado1);
		System.out.println("O valor do Segundo dado é: "+ dado2);
		
		if(dado1 == dado2) {
			System.out.println("Números repetidos!");
			int index = (int) (Math.random() * cores.length);
			System.out.println("Resultado do dado colorido: "+cores[index]);
			return true;
		}
		else {
			System.out.println("O valor de casas a ser andado é de: "+ SomaDados());
			return false;
		}
	}
}
