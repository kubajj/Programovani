import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.LinkedHashMap;


public class Uloha3 {		
	public static int prevodRA(String text) {	//tato metoda by měla fungovat, otestováno v classe PrevodRA.java	
		Map<Character, Integer> prevodnik = new HashMap<>();
		prevodnik.put('I', 1);
		prevodnik.put('V', 5);
		prevodnik.put('X', 10);
		prevodnik.put('L', 50);
		prevodnik.put('C', 100);
		prevodnik.put('D', 500);
		prevodnik.put('M', 1000);		
		int cislo = 0;
		char[] pismena = text.toCharArray();
		int[] cifry = new int[pismena.length];
		for (int i = 0; i < pismena.length; i++) {
			if (prevodnik.containsKey(pismena[i])) {
				cifry[i] = prevodnik.get(pismena[i]);
			} else {
				return 0;
			}
		}
		for (int i = 0; i < cifry.length; i++) {
			if (i == cifry.length - 1) {
				cislo += cifry[i];
				break;
			} else if (i == cifry.length - 2 && (cifry[i] == cifry[i + 1])) {
				cislo += 2 * cifry[i];
				break;
			} else if (cifry[i] < cifry[i + 1]) {				
				cislo -= cifry[i];
			} else if (cifry[i] > cifry[i + 1]){
				cislo += cifry[i];
			} else if ((cifry[i] == cifry[i + 1]) && (cifry[i] < cifry[i + 2])){
				cislo -= 2 * cifry[i];
				i++;
			} else if ((cifry[i] == cifry[i + 1]) && (cifry[i] >= cifry[i + 2])) {
				cislo += cifry[i];
			}
		}
		return cislo;
	}
	
	public static String prevodAR(int cislo) { 
		/*Map<Integer, Character> prevodnik = new HashMap<>();
		prevodnik.put(1, 'I');
		prevodnik.put(5, 'V');
		prevodnik.put(10, 'X');
		prevodnik.put(50, 'L');
		prevodnik.put(100, 'C');
		prevodnik.put(500, 'D');
		prevodnik.put(1000, 'M');	
		String preklad = "";
		
		return preklad;*/
		LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
		roman_numerals.put("M", 1000);
		roman_numerals.put("CM", 900);
		roman_numerals.put("D", 500);
		roman_numerals.put("CD", 400);
		roman_numerals.put("C", 100);
		roman_numerals.put("XC", 90);
		roman_numerals.put("L", 50);
		roman_numerals.put("XL", 40);
		roman_numerals.put("X", 10);
		roman_numerals.put("IX", 9);
		roman_numerals.put("V", 5);
		roman_numerals.put("IV", 4);
		roman_numerals.put("I", 1);
		String res = "";
		for(Map.Entry<String, Integer> entry : roman_numerals.entrySet()){
			int matches = cislo/entry.getValue();
			res += repeat(entry.getKey(), matches);
			cislo = cislo % entry.getValue();
		}	
		return res;
	}
		  
	public static String repeat(String s, int n) {
		if(s == null) {
			return null;
		}
		final StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(s);
		}
		return sb.toString();
	}
	
	public static void main (String[] args){
		System.out.println("Zadej směr převodu:\n| římské -> arabské(1) |\n| arabské -> římské (2)|");
		Scanner sc = new Scanner(System.in);		
		if (sc.hasNextInt()) {
			int volba = sc.nextInt();
			if (volba == 1) {
				System.out.println("Zvolil jste překlad z římských číslic do arabských.");
				while(true) {
					System.out.print("Zadej převáděné římské číslo:\n");
					if (sc.hasNext()){
						String text = sc.next();
						if (text.equals("konec")) {
							System.out.println("Program ukončen.");
							return;
						} else {							
							int cislo = prevodRA(text);
							if (cislo == 0) {	
								System.out.println("Chyba!");
							} else {							
								System.out.printf("V arabských číslovkách je to: %d\n", cislo);
							}
						}						
					} else {
						System.out.println("Něco se pokazilo!");
						return;
					}
				}
			} else if (volba == 2){
				while (true) {
					System.out.print("Zadej převáděné arabské číslo:");
					String vstup = sc.next();
					if (vstup.equals("konec")) {
						System.out.println("Program ukončen.");
						return;
					} else {							
						String preklad = prevodAR(Integer.parseInt(vstup));
						System.out.printf("V arabských číslovkách je to: %s\n", preklad);
					}						
				}
			} else {
				System.out.println("Taková monost ti nebyla dána.");
			}
		}		
	}
}
