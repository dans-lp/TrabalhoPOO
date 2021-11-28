package view;

public class ViewFacade {
    private static ViewFacade viewFac = null;
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
}