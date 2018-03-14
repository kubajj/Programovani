package kubajj.lekce21;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class NejdelsiRadek {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = Integer.MIN_VALUE;
		String nejdelsi = "";
		String nazev = "";
		while (sc.hasNext()) {
			String jmeno = sc.next();	
			try {				
				FileReader reader = new FileReader(jmeno);
				Scanner cteni = new Scanner(reader);
				while (cteni.hasNextLine()) {
					String precteno = cteni.nextLine();
					if (precteno.length() > max) {
						max = precteno.length();
						nejdelsi = precteno;
						nazev = jmeno;
					}
				}
			} catch (IOException e){
				System.out.printf("Nastala vyjimka u souboru %s.\n", jmeno);		
			}			
		}
		System.out.printf("\n\nNejdelsi radek je v souboru %s.\nJe to tento radek:\n%s\n", nazev, nejdelsi);
	}
}

