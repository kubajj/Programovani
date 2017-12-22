public class Vlnovka {
    public static boolean jeNaVlnovce(int pozice, int radek, int velikost){
	if (velikost == 1)
	    return true;
	int m = 2 * (velikost - 1);
	pozice = pozice % m;
        if (pozice == radek || pozice == m - radek) {
	    return true;
	} else {
	    return false;
	}
    }
    public static void main (String args[]) {
	int velikost = Integer.parseInt(args[0]);
	for (int radek = 0; radek < velikost; radek++) {
	    for (int pozice = 0; pozice < 80; pozice++) {
		if (jeNaVlnovce(pozice, radek, velikost)) {
		    System.out.print("#");
		} else {
		    System.out.print(" ");
		}
	    }
	    System.out.println();
	}
    }
}
