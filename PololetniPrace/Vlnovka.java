public class Vlnovka {
   public static void main (String args[]) {
	int velikost = Integer.parseInt(args[0]);
	int n = 2 * (velikost  - 1);
	for (int radek = 0; radek < velikost; radek++) {
	    for (int pozice = 0; pozice < 80;) {
		for (int m = 0; m < n; m++) {
		    pozice++;
		    if (pozice == 80)
			break;
		    if (m == radek || m == n - radek) {
			System.out.print("#");
		    } else {
			System.out.print(" ");
		    }
		}
	    }
	    System.out.println();
	}
    }
}
