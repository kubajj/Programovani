package kubajj.lekce14.Graf;

public class Graf {
	public static void main(String args[]) {
		int[] hodnoty = new int[100];
		int pocetHodnot = 0;
		int max = 0;
		java.util.Scanner sc = new java.util.Scanner(System.in);
		while (sc.hasNextInt()) {
			int cislo = sc.nextInt();
			if (cislo < 0) {
				continue;
			}
			hodnoty[pocetHodnot] = cislo;
			if (cislo > max) {
				max = cislo;
			}

			pocetHodnot++;
			if (pocetHodnot == hodnoty.length) {
				break;
			}
		}

		KreslicGrafu kreslic = null;
		if (args.length > 0) {
			if (args[0].equals("svg")) {
				kreslic = new DoSVG();
			} else {
				kreslic = new NaObrazovku();
			}
		}
		kreslic.kresli(hodnoty, pocetHodnot);
	}
}
