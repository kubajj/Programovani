public class Figurka {  
  public static void main (String args[]) {
    int chci = Integer.parseInt(args[0]);
    int zacatek = 0;
    int pole[] = new int[chci * 2];
    int pozice[] = new int[chci * 2];
    pole[0] = 0;
    for (int x = 1; x < chci * 2; x++) {
      pole[x] = 999;
    }
    int skoky[] = new int[] { 3, -3, 5, -5};
    for (int i = 1; i > 0; i++) {  
      for (int p = 0; i < chci * 2; i++) { 
        if (pozice[p] != 0) {     
          for (int s = 0; s < 4; s++) {
            if (pozice[p] + skoky[s] <= chci * 2 && pozice[p] + skoky[s] > 0) {
              if (pole[p + skoky[s]] !<= i) {
                pole[p + skoky[s]] = i;
              } 
            }
          }                
        }  
                           
      }       
    }
  }
}