package kubajj.lekce11;

public class PoleIntu {    
    private int pole[];
    private int pocet;
    public PoleIntu() {
	pocet = 0;
    }
 
    // Přidá číslo na konec "pole"
    public void pridej(int a) {
	if (pocet == 0)
	    pole = new int[16];
	else if (pole.length == pocet) {
	    int polenove[] = new int[pole.length * 2];
	    System.arraycopy(pole, 0, polenove, 0, pole.length);
	    pole = polenove;
	}
	pole[pocet++] = a;
    }
 
    // Vrátí počet prvků v poli
    public int delka() {
	return pocet;
    }
 
    // Řekne prvek na i-tém místě v poli
    public int prvek(int i) {
	return pole[i];
    }

       
}
