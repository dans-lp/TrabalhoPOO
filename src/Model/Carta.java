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
    * c04 
    * c15
*/

  public static String SorteiaCarta(){
    double aleatorio1 = Math.random();
    int cartaSorteada = (int) (aleatorio1 * (18-1));
  
    return carta[cartaSorteada];
  }

}

