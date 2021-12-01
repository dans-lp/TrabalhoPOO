package controller;

import view.ViewFacade;

 class Main {

	public static void main(String[] args) {
		ViewFacade telaInicial = ViewFacade.getViewFacade();
		
		telaInicial.iniciaView();
	}

}