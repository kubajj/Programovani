public class OtoceniIIint {
    public static void main(String args[]) {
	   int pocet = 0;    //pocet vypsanych cisel
	   int cisla[] = new int[1];
        System.out.printf("Zadejte neomezeny pocet cisel:\n");
        java.util.Scanner sc = new java.util.Scanner(System.in);
	while (sc.hasNextInt()) {
	    if (pocet >= cisla.length) {
		int cislanew[] = new int[cisla.length * 2];
		for (int i = 0; i < cisla.length; i++) {
		    cislanew[i] = cisla[i];
		}
		cisla = cislanew;
	    }
	    cisla[pocet++] = sc.nextInt();
	}
	System.out.println();
	System.out.printf("Pozpatku:");
	for (int a = pocet - 1; a >= 0; a-- ){
	    System.out.printf(" %d", cisla[a]);
	}
	System.out.println();
    }
}