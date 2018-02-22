package kubajj.lekce9;

public class OtoceniIdouble {
    public static void main(String args[]) {
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
	double polecisel[] = new double[pocet];
        for (int n = 0; n < pocet; n++){
            polecisel[n] = cisla[n];
        }
	System.out.println();
	System.out.printf("Pozpatku:");
	for (int a = pocet - 1; a >= 0; a-- ){
	    System.out.printf(" %f", polecisel[a]);
	}
	System.out.println();
    }
}
