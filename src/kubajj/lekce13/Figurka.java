public class Figurka {  
  public static void main (String args[]) {
    int chci = Integer.parseInt(args[0]);
    int zacatek = 0;
    int pole[] = new int[chci * 2]; //na kolikaty skok jsem se kam dostal
    int jsem[] = new int[chci * 2]; //pozice na ktere se nachazim
    pole[0] = 0;
    for (int x = 1; x < chci * 2; x++) {
      pole[x] = 999;
      jsem[x] = 999;
    }
    int skoky[] = new int[] { 3, -3, 5, -5};
    for (int cisloskoku = 1; cisloskoku > 0; cisloskoku++) {
	int tedjsem[] = new int[chci * 2];
	int pocet = 0;
	for (int i = 0; i < chci * 2; i++) {
	    if (jsem[i] == cisloskoku - 1) {
		for (int s = 0; s < 4; s++) {
		    if (jsem[i] + skoky[s] < pole[i]) {
			pole[i] = cisloskoku;
			tedjsem[pocet] = pole[i];
		    }
		    if (jsem[i] + skoky[s] == chci) {
			System.out.printf("Na policko cislo %d je mozne se dostat behem %d skoku.\n", chci, cisloskoku);
			return;
		    }
		}		
	    }
	}
	jsem = tedjsem;
    }
  }
}
