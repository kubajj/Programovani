import java.util.Scanner;

public class SoustavaRovnic {
	public static void main (String[] args) {
		int pocetx = Integer.parseInt(args[0]);
		int pole[][] = new int[pocetx][pocetx + 1];
		int starepole[][] = new int[pocetx][pocetx + 1];
		int polex[] = new polex[pocetx];
		int x = 0;
		Scanner sc = new Scanner();
		for (int i = 0; i < pocetx; i++) {
			for (int x = 0; x < pocetx + 1; x++) {
				pole[i][x] = sc.nextInt();
				starepole[i][x] = sc.nextInt();
			}			
		}
		
		for (int i = 0; i < pocetx; i++) {
			for (int x = 0; x < pocetx; i++) {
				if (pole[i][x] == pole[i + 1][x]) {
					for (int pozice = 0; pozice < pocetx; pozice++) {
						pole[i + 1][pozice] -= pole[i][pozice];
					}		
					break;
				}
				if (pole[i][x] == -pole[i + 1][x]) {
					for (int pozice = 0; pozice < pocetx; pozice++) {
						pole[i + 1][pozice] += pole[i][pozice];
					}		
					break;
				}
				if (x == pocetx - 1) {
					for (int pozice = 0; pozice < pocetx; pozice++) {
						pole[i][pozice] *= -pole[i + 1][pozice];
					}		
					for (int pozice = 0; pozice < pocetx; pozice++) {
						pole[i + 1][pozice] += pole[i][pozice];
					}		
					break;
				}
			}
			int pocetcisel = pocetx + 1;
			int cisla[] = new int[2];		
			int pocet = 0;
			for (int n = 0; n < pocetx + 1; n++) {
				if (pole[i + 1][n] == 0) {
					pocetcisel--;
				} else {
					cisla[pocet++] = pole[i + 1][n];
				}
			}
			if (pocetcisel == 2) {
				cisla[1] /= cisla[0];
				polex[x++] = cisla[1];
			}
		}
		
	}
}
