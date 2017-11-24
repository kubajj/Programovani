public class Grafy{
    public static void main(String args[]){
          double cisla[] = new double[100];
          System.out.printf("Zadejte maximalne 100 cisel:\n");
          java.util.Scanner sc = new java.util.Scanner(System.in);
          int pocet = 0;
	  if (!sc.hasNextDouble()) {
	      System.out.printf("Nezadal jste zadne cislo.\n");
	      return;
	  }
	  while (sc.hasNextDouble() && pocet < 100) {
                cisla[pocet++] = sc.nextDouble();
	  }
	  boolean prvni = true;
          double maximum = 0;
          for (int i = 0; i < pocet; i++){
                  if (prvni) {
                    maximum = cisla[i];
                    prvni = false;
                  } else {
                  if (cisla[i] > maximum) {
                    maximum = cisla[i];
                    }
                  }
          }
          double jednotka = 60./maximum;
          for (int x = 0; x < pocet; x++){
	     for (int a = 1; a <= cisla[x] * jednotka; a++ ){
                    System.out.printf("#");
                    
              }
              System.out.println();
          }
    }
 }

   
