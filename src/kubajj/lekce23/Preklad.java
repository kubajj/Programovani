package kubajj.lekce23;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Preklad {
	public static void main (String[] args) {
		Scanner vstup = new Scanner(System.in);
		System.out.println("Zadejte jmeno souboru se slovnikem.");
		Map <String, String> slovnik = new HashMap<>();
		try {
			Scanner sc = new Scanner(java.nio.file.Paths.get(vstup.next()));
			while (sc.hasNextLine()) {
				String slovo = sc.next();
				String preklad = sc.next();
				slovnik.put(slovo, preklad);
			}
			sc.close();
		} catch (IOException e) {
			System.out.printf("Chyba: %s!", e.getMessage());
			return;
		}
		System.out.println("Zadejte text k prekladu.");
		String prelozeno = "";
		while(vstup.hasNext()) {			
			if (!slovnik.containsKey(vstup.next())) {
				continue;
			}
			prelozeno += " " + slovnik.get(vstup.next());
		}
		vstup.close();
		System.out.printf("Vas prelozeny text je:\n%s", prelozeno);
	}
}
