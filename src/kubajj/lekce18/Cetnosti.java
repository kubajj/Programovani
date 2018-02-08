package kubajj.lekce18;

import java.util.HashMap;
import java.util.Map;

public class Cetnosti {
	public static void main(String[] args) {
		Map<Integer, Integer> cisla = new HashMap<>(); 
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (scanner.hasNextInt()) {
            int cislo = scanner.nextInt();
            Integer hodnota = cisla.get(cislo);
            if (hodnota == null) {
            	cisla.put(cislo, 1);
            } else {
            	cisla.put(cislo, hodnota + 1);
            }
        }
         
        for (Integer c : cisla.keySet()) {
            System.out.printf("%3d tam bylo %dx.\n", c,
                cisla.get(c));
        }
    }
}
