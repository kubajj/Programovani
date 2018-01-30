public class OtoceniIIdouble {
    public static void main(String args[]) {
	int pocet = 0;
	double cisla[] = new double[1];
        System.out.printf("Zadejte neomezeny pocet cisel:\n");
        java.util.Scanner sc = new java.util.Scanner(System.in);
	while (sc.hasNextDouble()) {
	    if (pocet == cisla.length) {
		double cislanew[] = new double[cisla.length * 2];
		for (int i = 0; i < cisla.length; i++) {
		    cislanew[i] = cisla[i];
		}
		cisla = cislanew;
	    }
	    cisla[pocet++] = sc.nextDouble();
	}
	System.out.println();
	System.out.printf("Pozpatku:");
	for (int a = pocet - 1; a >= 0; a-- ){
	    System.out.printf(" %f", cisla[a]);
	}
	System.out.println();
    }
}
