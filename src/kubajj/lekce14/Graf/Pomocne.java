package Graf;

public class Pomocne {
	public static int maximum(int[] hodnoty, int pocet) {
		int max = hodnoty[0];
		for (int i = 1; i < pocet; i++) {
			if (hodnoty[i] > max) {
				max = hodnoty[i];
			}
		}
		return max;
	}
	
	public static void opakujZnak(char znak, long kolikrat) {
        while (kolikrat > 0) {
            System.out.printf("%c", znak);
            kolikrat--;
        }
    }
}

