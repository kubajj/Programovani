import java.util.Calendar;
import java.util.Date;
public class Kalendar {
    public static boolean isInteger(String s) {
	//zdroj: https://stackoverflow.com/questions/5439529/determine-if-a-string-is-an-integer-in-java
	try { 
	    Integer.parseInt(s); 
	} catch(NumberFormatException e) { 
	    return false; 
	} catch(NullPointerException e) {
	    return false;
	}    
	return true;
    }
   
    public static int prvniDenMesice(int mesic, int rok) {
	int poradidne = 0;
	int den = 1;
	Calendar cal = Calendar.getInstance();
	cal.set(rok, mesic - 1, den);
	int day = cal.get(Calendar.DAY_OF_WEEK);
	if (day == 1) {
	    day = 7;
	} else {
	    day--;
	}
	return day;
    }

    public static String jmenoMesice(int mesic) {
	String mesice[] = new String[] { "Leden", "Unor", "Brezen", "Duben", "Kveten", "Cerven", "Cervenec", "Srpen", "Zari", "Rijen", "Listopad", "Prosinec"};
	return mesice[mesic - 1];
    }

    public static int delkaJmenaMesice (int mesic) {
	int pocetpismen[] = new int[] { 5, 4, 6, 5, 6, 6, 8, 5, 4, 5, 8, 8};
	return pocetpismen[mesic - 1];
    }

    public static boolean jePrestupny(int rok) {
        boolean delitelny4 = (rok % 4) == 0;
        boolean delitelny100 = (rok % 100) == 0;
        boolean delitelny400 = (rok % 400) == 0;
 
        if (delitelny400) {
            return true;
        } else if (delitelny100) {
            return false;
        } else {
            return delitelny4;
        }
    }
 
    public static int dnuVMesici(int rok, int mesic) {
        int[] dny = new int[] { 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (mesic == 2) {
            if (jePrestupny(rok)) {
                return 29;
            } else {
                return 28;
            }
        } else {
            return dny[mesic - 1];
        }
    }

    public static String[] tabulka(int radek, int mesic, int rok, int zacatek) {
	String jmenomesice = jmenoMesice(mesic);
	int delkajmenamesice = delkaJmenaMesice(mesic);
	int prvniden = prvniDenMesice(mesic, rok);	
	int pocetdni = dnuVMesici(rok, mesic);
	int delkaletopoctu = (int)Math.log10(rok);
	String vyroky[] = new String[2];
	String tisk = "";
	String jsemu = "";
	if (radek == 1 || radek == 3 || radek == 11) {
	    tisk = "+----------------------+";
	    jsemu = " ";
	} else if (radek == 2) { // max 24
	    String doplnek = "";
	    jsemu = " ";
	    for (int cislo = 8 - delkajmenamesice; cislo > 0; cislo--) {
		doplnek = doplnek + " ";
	    }
	    String doplnekII = "";
	    for (int cislo = 4 - delkaletopoctu; cislo > 0; cislo--) {
		doplnekII = doplnekII + " ";
	    }
	    tisk = "| " + jmenomesice + " " + rok + doplnek + doplnekII + "       |";	    
	} else if (radek == 4) {
	    jsemu = " ";
	    tisk = "| Po Ut St Ct Pa So Ne |";
	} else if (radek == 5) {
	    String mezery = "";
	    for (int cislo = 1; cislo < prvniden; cislo++) {
		mezery = mezery + "   ";
	    }
	    String cisla = "";
	    boolean poprve = true;
	    int vypsano = 0;
	    int number = 1;
	    while (vypsano < 8 - prvniden){			
		if (poprve) {
		    cisla = cisla + " " + number;
		    number++;
		    poprve = false;
		} else {
		    cisla = cisla + "  " + number;
		    number++;
		}
		vypsano++;
	    }
	    jsemu = "" + number;
	    tisk = "| " + mezery + cisla + " |";
	} else if (radek >= 6 && radek <= 10) {
	    String cisla = "";
	    int policek = 21;
	    if (zacatek + 1 > pocetdni) {
		tisk ="|                      |";
		jsemu = "" + 1000;
	    } else {
		for (int cislo = 1; cislo <= 7; cislo++) {
		    int number = (8 - prvniden + cislo) + (radek - 6) * 7;
		    if (number > pocetdni) {
			String mezery = "";
			for (int i = policek; i > 0; i--) {
			    mezery = mezery + " ";
			}
			cisla = cisla + mezery;
			jsemu = "" + (number - 1);
			break;
		    }
		    if (number < 10) {
			cisla = cisla + " " + number + " ";
		    } else {
			cisla = cisla + number + " " ;
		    }
		    policek -= 3;
		    jsemu = "" + number;
		}
		tisk = "| " + cisla + "|";
	    }	    
	}
	vyroky[0] = tisk;
	vyroky[1] = jsemu;
	return vyroky;
    }
    
    public static void main (String args[]) {
	java.util.Scanner sc = new java.util.Scanner(System.in);
	int mesic;
	int rok;
	Calendar c = Calendar.getInstance();
        String pole[] = new String[2];
	int pocet = 0;
	for (String prvek: args) {
	    pole[pocet++] = prvek;
	}
	if ((!isInteger(pole[0]) || !isInteger(pole[1])) && pocet == 2) {
	    System.out.println("Chyba!");
	    return;
	} else if (pocet == 2) {
	    mesic = Integer.parseInt(pole[0]);
	    if (mesic <= 0 || mesic > 12) {
		System.out.println("Chyba!");
		return;
	    }
	    rok = Integer.parseInt(pole[1]);	    
	} else if (pocet == 1) {
	    mesic = Integer.parseInt(pole[0]);
	    if (mesic <= 0 || mesic > 12) {
		System.out.println("Chyba!");
		return;
	    }
	    rok = c.get(Calendar.YEAR);
	} else  if (pocet == 0) {
	    rok = c.get(Calendar.YEAR);
	    mesic = c.get(Calendar.MONTH) + 1;
	} else {
	    return;
	}
	System.out.println("Kolik mesicu mam vytisknout?\n[1/3]\n");
	String odpoved = sc.next();
	System.out.println();
	if (!isInteger(odpoved)) {
	    System.out.println("Chyba!\n");
	    return;
	}
	int odp = Integer.parseInt(odpoved);
	if (odp != 1 && odp != 3) {
	    System.out.println("To vubec nebylo v nabidce!");
	    System.out.println("Chyba!\n");
	    return;
	}
	if (odp == 1) {
	    int zacatek = 1;
	    String tisk = "";
	    for (int radek = 1; radek < 12; radek++) {
		String vysledek[] = tabulka(radek, mesic, rok, zacatek);
		tisk = vysledek[0];
		if (radek > 4 && radek != 11) {
		    String jsemu = vysledek[1];
		    zacatek = Integer.parseInt(jsemu);
		}
		System.out.printf("%s\n", tisk);
	    }	    
	}
	if (odp == 3) {	
	    int zacatek = 1;
	    int zacatek1 = 1;
	    int zacatek2 = 1;
	    int mesic1 = mesic - 1;
	    int rok1 = rok;
	    if (mesic1 == 0) {
		mesic1 = 12;
		rok1--;
	    }
	    int mesic2 = mesic + 1;
	    int rok2 = rok;
	    if (mesic2 == 13) {
		mesic2 = 1;
		rok2++;
	    }
	    String tisk = "";
	    for (int radek = 1; radek < 12; radek++) {
		String vysledekpred[] = tabulka(radek, mesic1, rok1, zacatek1);
		tisk = vysledekpred[0];
		if (radek > 4 && radek != 11) {
		    String jsemu1 = vysledekpred[1];
		    zacatek1 = Integer.parseInt(jsemu1);
		}	    
		String vysledek[] = tabulka(radek, mesic, rok, zacatek);
		tisk = tisk + " " + vysledek[0];
		if (radek > 4 && radek != 11) {
		    String jsemu = vysledek[1];
		    zacatek = Integer.parseInt(jsemu);
		}
		String vysledekpo[] = tabulka(radek, mesic2, rok2, zacatek2);
		tisk = tisk + " " + vysledekpo[0];
		if (radek > 4 && radek != 11) {
		    String jsemu2 = vysledekpo[1];
		    zacatek2 = Integer.parseInt(jsemu2);
		}	    
		System.out.printf("%s\n", tisk);
	    }
	}
    }
}
