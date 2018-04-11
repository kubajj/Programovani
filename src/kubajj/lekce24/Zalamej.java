package kubajj.lekce24;

import java.util.Scanner;

public class Zalamej {
	public final static int MAX_SIRKA = 50;
	
	public static void main(String[] args) {
		Scanner vstup = new Scanner(System.in);
		
		DetektorOdstavcu odstavce = new DetektorOdstavcu(vstup);
		
		while (odstavce.hasNextParagraph()) {
			Odstavec odst = odstavce.nextParagraph();
			
			Zalamovac zalam = new Zalamovac(MAX_SIRKA, System.out);
			while (odst.hasNextWord()) {
				String slovo = odst.nextWord();
				zalam.pridej(slovo);
			}
			
			zalam.hotovo();
		}
	}
}