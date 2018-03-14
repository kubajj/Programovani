package Soutez;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class PrevodRA { //převádí římské číslice do arabských
	public static void main(String[] args) {
		Scanner rimske = new Scanner(System.in);
		while (rimske.hasNext()) {
			String rimskecislo = rimske.next();
			Map<Character, Integer> prevodnik = new HashMap<>();
			prevodnik.put('I', 1);
			prevodnik.put('V', 5);
			prevodnik.put('X', 10);
			prevodnik.put('L', 50);
			prevodnik.put('C', 100);
			prevodnik.put('D', 500);
			prevodnik.put('M', 1000);		
			int cislo = 0;
			char[] pismena = rimskecislo.toCharArray();
			int[] cifry = new int[pismena.length];
			for (int i = 0; i < pismena.length; i++) {
				if (prevodnik.containsKey(pismena[i])) {
					cifry[i] = prevodnik.get(pismena[i]);
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
			System.out.printf("%d\n", cislo);
		}
	}
}