package kubajj.lekce21;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class SudaALicha {
	public static void main (String[] args) throws NumberFormatException, IOException{
		int konec = Integer.parseInt(args[0]);	
		PrintWriter suda = new PrintWriter("suda.txt");
		int vypsanosudych = 0;
		PrintWriter licha = new PrintWriter("licha.txt");
		int vypsanolichych = 0;
		if (konec == 1 || konec == 0) {
			System.out.println("Zadal jste moc male cislo.");
			return;
		}
		for (int i = 1; i < konec; i++) {
			if (i % 2 == 0) {
				suda.printf("%d ", i);
				if (vypsanosudych == 10) {
					suda.println();
					vypsanosudych = 0;
				}
				vypsanosudych++;
			} else {
				licha.printf("%d ", i);
				if (vypsanolichych == 10) {
					licha.println();
					vypsanolichych = 0;
				}
				vypsanolichych++;
			}
		}
		suda.println();
		suda.close();
		licha.println();
		licha.close();
	}
}
