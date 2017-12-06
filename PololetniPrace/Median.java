public class Median {
    public static int[] razeni(int[] pole, int length){
	for (int zacatek = 0; zacatek < length; zacatek++) {
	    int minimum = 0;
	    int poziceminima = 0;
	    for (int i = zacatek; i < length; i++) {
		if (i == zacatek || pole[i] < minimum) {
			minimum = pole[i];
			poziceminima = i;		    
		}
	    }
	    pole[poziceminima] = pole[zacatek];
	    pole[zacatek] = minimum;
	}
	return pole;
    }
    
    public static void main(String[] args) {
	int pocet = 0;
	int cisla[] = new int[1];
	System.out.print("Zadejte cisla:\n");
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
	System.out.printf("Napsano:");
	for (int a = 0; a < pocet; a++ ){
	    System.out.printf(" %d", cisla[a]);
	}
	System.out.println();
	cisla = razeni(cisla, pocet);
	System.out.printf("Setrideno:");
	for (int a = 0; a < pocet; a++ ){
	    System.out.printf(" %d", cisla[a]);
	}
	System.out.println();
	if ((pocet % 2) == 0) {
	    double median = (cisla[pocet / 2] + cisla[pocet / 2 + 1]) / 2;
	    System.out.printf("Median techto cisel je %f.\n", median);
	} else {
	    int median = (cisla[pocet / 2]);
	    System.out.printf("Median techto cisel je %d.\n", median);
	}
    }
}
