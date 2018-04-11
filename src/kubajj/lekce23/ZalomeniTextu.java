package kubajj.lekce23;

//import java.io.PrintWriter;
import java.util.Scanner;

public class ZalomeniTextu {
	public static String zalamovani(Scanner text) {
		int sirka = 25;
		int vypsano = 0;
		String vratit = "";
		String soucasny = "";
		while (text.hasNextLine()) {
			String radka = text.nextLine();
			Scanner cteni = new Scanner(radka);
			if (radka.equals("\n")) {
				vratit += "\n";
				continue;
			}
			while (cteni.hasNext()) {
				soucasny = cteni.next() + " ";
				vypsano += soucasny.length();
				if (vypsano > sirka) {
					vratit += "\n";
					vypsano = soucasny.length();
				}
				vratit += soucasny;
			}
		}
		return vratit;		
	}
	
	public static void main (String[] args) {		
		Scanner text = new Scanner(System.in);
		System.out.printf("%s", zalamovani(text));
		text.close();
	}
}
