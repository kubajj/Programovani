public class PascaluvTrojuhelnik {
    public static int[] novePole(int[] pole, int length){
	int novePole[] = new int[length];
	novePole[0] = 1;	     
	for(int i = 1; i < length - 1; i++){
	    novePole[i] = pole[i-1] + pole[i];
	}
	novePole[length - 1] = 1;
	return novePole;
    }

    public static void opakujZnak(char znak, int pocet){
	while(pocet > 0){
	    System.out.printf("%c", znak);
	    pocet--;
	}
    }

    public static int faktorial(int n) {                    //vzato z domaciho ukolu kombinacni cislo
        if (n <= 1) {
            return 1;
        }
        int vysledek = 1;
        while (n > 0) {
            vysledek *= n;
            n--;
        }
        return vysledek;
    }

    public static int maximum(int cislo){                  //upraveno z ukolu kombinacni cislo
	int n = cislo;
	int k = cislo  / 2;
        if ((k == 0) || (k == n)) {
            return 1;
        }
	int vysledek = 1;
        int jmenovatel_cinitel = 2;
        int jmenovatel_konec = n - k;
        for (int i = k + 1; i <= n; i++) {
            vysledek *= i;
            while ((jmenovatel_cinitel <= jmenovatel_konec)
                    && ((vysledek % jmenovatel_cinitel) == 0)) {
                vysledek /= jmenovatel_cinitel;
                jmenovatel_cinitel++;
            }
        }
 
        return vysledek;
    }

    public static void main (String args[]){
          //chtelo by to vzit nove prazdne pole
          //secist predesle pole a dat data do toho dalsiho pole pole
	int pocetradku = Integer.parseInt(args[0]);
	int velikostpole = 1;
	int pole[] = new int[velikostpole];
	int maximum = maximum(pocetradku - 1);
	int pocetmist = 0;
	if (maximum == 1){
	    pocetmist = 2;                                 //je jedno jestli je to 1 nebo 2, stejne je to vzdy sude
	} else {
	    pocetmist = (int)Math.log10(maximum - 1) + 2;  //realne je to delka nejdelsiho cisla trojuhelniku + 1
	}
	if ((pocetmist % 2) != 0){
	    pocetmist++;                                   //vsechny pocty mist jsou sude, je to pak lepe zarovnano
	}
	if (pocetradku <= 0){
	    System.out.print("Moc nechapu co mam tisknout...\n");
	} else {
	    boolean poprve = true;
	    int radek = 1;
	    for (int i = 1; i <= pocetradku; i++){
		if (poprve){
		    pole[0] = 1;
		    poprve = false;
		} else {		
		velikostpole++;
		int novepole[] = novePole(pole, velikostpole);
		pole = novepole;
		}
		boolean prvnicislo  = true;
		for(int a = 0; a < velikostpole; a++){
		    if (prvnicislo) {
			opakujZnak(' ', (pocetradku - radek) * pocetmist / 2);
			prvnicislo = false;
			System.out.printf("%d",pole[a]);
		    } else {
			String format =  "%" + pocetmist + "d";
			System.out.printf(format, pole[a]);
		    }
		}
		System.out.println();
		radek++;
	    }
	}
   }
}
