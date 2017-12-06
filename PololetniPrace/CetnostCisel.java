public class CetnostCisel {    
    public static void main (String args[]) {
	int pocet = 0;    //pocet vypsanych cisel    //z meho ukolu na OtoceniII
	int cisla[] = new int[1];
        System.out.printf("Zadejte neomezeny pocet cisel:\n");
        java.util.Scanner sc = new java.util.Scanner(System.in);
	while (sc.hasNextInt()) {
	    if (pocet >= cisla.length) {
		int cislanew[] = new int[cisla.length * 2];
		System.arraycopy(cisla, 0, cislanew, 0, cisla.length);
		cisla = cislanew;
	    }
	    cisla[pocet++] = sc.nextInt();
	}
	java.util.Arrays.sort(cisla, 0, pocet);
	for(int a = 0; a < pocet; a++){
	    System.out.printf("%d ", cisla[a]);
	}
	System.out.printf("\n\n");
	int max = pocet;
        while (max > 0) {
	    int maxdelka = 0;
	    int prvni = 0;
	    int posledni = 0;
	    int m;
	    for (int n = 0; n < pocet; n = m) {
		m = n + 1;
		while (m < pocet && cisla[m] == cisla[n])
		    m++;
		if (m - n <= max && m - n > maxdelka) {
		    maxdelka = m - n;
		    prvni = n;
		}
		if (m - n == maxdelka) {
		    posledni = n;
		}
	    }
	    for (int n = prvni; n <= posledni; n = m) {
		m = n + 1;
		while (m < pocet && cisla[m] == cisla[n])
		    m++;
		if (m - n == maxdelka) {
		    System.out.printf("%d jste zadal %d-krat.\n", cisla[n], m - n);
		}
	    }
	    max = maxdelka - 1;
	}

    }
}
