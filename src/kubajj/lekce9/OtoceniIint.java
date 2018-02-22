package kubajj.lekce9;

public class OtoceniIint {
    public static void main(String args[]) {
	int cisla[] = new int[100];
        System.out.printf("Zadejte maximalne 100 cisel:\n");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int pocet = 0;
        for (int i = 0; i < 100; i++) {
            if (!sc.hasNextInt()) {
              break;
            }
            cisla[i] = sc.nextInt();
            pocet++;                
        }
	System.out.println();
	System.out.printf("Pozpatku:");
	for (int a = pocet - 1; a >= 0; a-- ){
	    System.out.printf(" %d", cisla[a]);
	}
	System.out.println();
    }
}
