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

    public static void main (String args[]){
          //chtelo by to vzit nove prazdne pole
          //secist predesle pole a dat data do toho dalsiho pole pole
	int pocetradku = Integer.parseInt(args[0]);
	int velikostpole = 1;
	int pole[] = new int[velikostpole];
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
			opakujZnak(' ', (pocetradku - radek) * 2);
			prvnicislo = false;
			System.out.printf("%d",pole[a]);
		    } else {
		    System.out.printf("%4d", pole[a]);
		    }
		}
		System.out.println();
		radek++;
	    }
	}
   }
}
