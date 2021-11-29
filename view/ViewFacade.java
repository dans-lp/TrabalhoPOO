package view;

import Model.ModelFacade;

public class ViewFacade {
    private static ViewFacade viewFac = null;
    private static ModelFacade model= ModelFacade.getModelFacade();

    
    private TelaInicial tela;

    private ViewFacade() {}

    public static ViewFacade getViewFacade () {
        if (viewFac == null)
            viewFac = new ViewFacade();
        return viewFac;
    }

    public void iniciaView() {
        tela = new TelaInicial();
    }
    
    public static int getValorDado1Padrao(){
    	return model.ValorDado1Padrao();
    }
    public static int getValorDado2Padrao(){
    	return model.ValorDado2Padrao();
    }
    public static int getValorDado1Comp(){
    	return model.ValorDado1Competitivo();
    }
    public static int getValorDado2Comp(){
    	return model.ValorDado2Competitivo();
    }
    public static int getValorDado1Duplas(){
    	return model.ValorDado1Duplas();
    }
    public static int getValorDado2Duplas(){

    	return model.ValorDado2Duplas();
    }
    
    public int TipodeMovimento() { 
    	return DesenhaTabuleiro.tipomov;
    }
    public int NumdoPeao() {
    	return DesenhaTabuleiro.numPeao;	
    }
    public int CasaFinal() {

    	
    	return DesenhaTabuleiro.Numcasa;
    	
    }
    
    public static void ModoJogo(int modojogo) {
    	model.ComecaJogoModel (modojogo);
    	
    }
}
