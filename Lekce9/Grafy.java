 public class Grafy{
    public static void main(String args[]){
          double cisla[] = new double[100];
          System.out.printf("Zadejte maximalne 100 cisel:\n");
          java.util.Scanner sc = new java.util.Scanner(System.in);
          int pocet = 0;
          for (int i = 0; i < 100; i++) {
                if (!sc.hasNextDouble()) {
                    break;
                }
                cisla[i] = sc.nextDouble();
                pocet++;                
          }
          double cisladografu[] = new double[pocet];
          for (int n = 0; n < pocet; n++){
                cisladografu[n] = cisla[n];
          }
          boolean prvni = true;
          double maximum = 0;
          for (int i = 0; i < cisladografu.length; i++){
                  if (prvni) {
                    maximum = cisladografu[i];
                    prvni = false;
                  } else {
                  if (cisladografu[i] > maximum) {
                    maximum = cisladografu[i];
                    }
                  }
          }
          double jednotka = 60./maximum;
          System.out.printf("Maximum je %.2f, jednotka %.4f\n", maximum, jednotka);
          for (int x = 0; x < cisladografu.length; x++){
                    for (int a = 1; a <= cisladografu[x] * jednotka; a++ ){
                          System.out.printf("#");
                    
              }
              System.out.println();
          }
          
    }
 }