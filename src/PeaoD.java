import java.util.Scanner;

public class PeaoD {

    private int num_peao = 6;
    private static String cores[] = {"preto","verde","amarelo", "azul"};    
    
public int contajogador(int num_jogador) {
    int totalpeao = num_jogador*num_peao;
    return totalpeao;    
}

public void associa(int num_jogador) {
    
    
    
    for(int i=0; i<num_jogador; i++) {
        System.out.printf("Cor do Jogador %d é %s\n",i+1,cores[i]);
        
    }    
}
    public static void main(String[] args) {
    
        PeaoD myclass =  new PeaoD();
        PeaoD cores = new PeaoD();
        Scanner teclado = new Scanner (System.in);
        System.out.print("Entre com o numero de jogadores: ");
        int num_jogador = teclado.nextInt();
        System.out.println("Num jogador: "+myclass.contajogador(num_jogador));    
        cores.associa(num_jogador);
    }
}
