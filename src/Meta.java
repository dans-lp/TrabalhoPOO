package model;

class Meta {
	
	private static int qtd; //Max: 12
	private boolean disponivel;
	
	public Meta() {
		qtd++;
		disponivel = true;
	}
	
	public int qtdDeMetas() {
		return qtd;
	}
	
	public boolean metaDisponivel() {
		return disponivel;
	}
	
	public void atingiuMeta() {
		disponivel = false;
		return;
	}

}
