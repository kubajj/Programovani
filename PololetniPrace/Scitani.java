public class Scitani {
    public static void main(String args[]) {
	java.util.Random nahoda = new java.util.Random();
	java.util.Scanner sc = new java.util.Scanner(System.in);
	int uspesnost = 0;
	int pocetprikladu = 0;
	for (int i = 0; i < 10; i++) {
	    int a = nahoda.nextInt(20);
	    int b = nahoda.nextInt(20);
	    if (a + b > 20) {
		i--;
		continue;
	    } else if (a == 0 || b == 0) {
		i--;
		continue;
	    }
	    String znamenko = "+";
	    int sign = nahoda.nextInt(3);
	    if (sign == 0) {
		i--;
		continue;
	    } else if (sign == 1) {
	        znamenko = "+";
	    } else {
	        znamenko = "-";
		if (a < b) {
		    System.out.println("Ted neco mozna trochu tezsiho.");
		}
	    }
	    String priklad = a + " " + znamenko + " "  +  b +  " =";
	    String vypocet = a + znamenko +  b;
	    System.out.printf("%2d.) %s\n", i + 1, priklad);
	    pocetprikladu++;
	    int vysledek = 0;
	    if (sign == 1) {
		vysledek = a + b;
	    } else {
		vysledek = a - b;
	    }
	    if (sc.hasNextInt()) {
		int vysledekuzivatele = sc.nextInt();
		if (vysledek != vysledekuzivatele) {
		    System.out.printf("Chyba, spravny vysledek je %d.\n\n", vysledek);
		    if (i != 9) {
			System.out.println("Zkuste radeji dalsi priklad.");		    
		    }	
		} else {
		    System.out.println("Spravne.\n");
		    if (i != 9) {
			System.out.println("Zde je dalsi priklad.");
		    }
		    uspesnost++;		
		}
	    } else {
		pocetprikladu--;
		break;
	    }
	}
	double procento = uspesnost / pocetprikladu;
	String vyrok;
	if (procento >= 0.90) {
	    vyrok = "Vyborne";
	} else if (procento >= 0.75) {
	    vyrok = "Je co zlepsovat, ale velmi dobre";
	} else if (procento >= 0.50) {
	    vyrok = "Dobre";
	} else if (procento >= 0.35) {
	    vyrok = "To se vam uplne nepovedlo";
	} else {
	    vyrok = "Zkuste to radeji znovu, vase skore je totiz prilis nizke";
	}
	if (uspesnost == 1) {
	    System.out.printf("\n%s, spravne jste splnil %d priklad z %d.\n", vyrok, uspesnost, pocetprikladu);
	} else if (uspesnost < 5 && uspesnost != 0) {
	    System.out.printf("\n%s, spravne jste splnil %d priklady z %d.\n", vyrok, uspesnost, pocetprikladu);
	} else {
	    System.out.printf("\n%s, spravne jste splnil %d prikladu z %d.\n", vyrok, uspesnost, pocetprikladu);
	}
    }
}
