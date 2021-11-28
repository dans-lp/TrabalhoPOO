package Model;

class Carta{

  private static String carta[] = new String[18];
  
  public Carta(){
    for(int i = 0; i < 10; i++){
      carta[i] = "C0" + (i + 1) + ".png";
    }

    for(int j = 10; j<18; j++){
      carta[j] = "C" + (j+1) + ".png";
    }
  }

/*
  * cartas usadas:
    * c01: Um explorador anda 6 casas
    * c08: Conquiste imediatamente o polo oposto com um de seus exploradores
*/

  public static String SorteiaCarta(){
    double aleatorio1 = Math.random();
    int cartaSorteada = (int) (aleatorio1 * (18-1));
  
    return carta[cartaSorteada];
  }

}

