package kubajj.lekce21;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MinMax {
	public static void main (String[] args) throws IOException {
		FileReader reader = new FileReader("cisla.txt");		
		Scanner sc = new Scanner(reader);
		int nejmensi = Integer.MAX_VALUE;
		int nejvetsi = Integer.MIN_VALUE;
		while (sc.hasNextInt()) {
			int cislo = sc.nextInt();
			if (cislo < nejmensi) {
				nejmensi = cislo;
			}
			if (cislo > nejvetsi) {
				nejvetsi = cislo;
			}
		}
		reader.close();
		sc.close();				
		System.out.printf("Nejmensi: %d\nNejvetsi: %d\n", nejmensi, nejvetsi);
	}
}
