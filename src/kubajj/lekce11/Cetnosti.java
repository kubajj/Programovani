package kubajj.lekce11;

public class Cetnosti {
    private int pole[];
    private int pocet;
    public Cetnosti() { pocet = 0; }
    public void zapocitej(int cislo) {
	for (int i = 0; i < pocet; i += 2)
	    if (pole[i] == cislo) {
		pole[i + 1]++;
		return;
	    }
	if (pocet == 0)
	    pole = new int[16];
	else if (pole.length == pocet) {
	    int polenove[] = new int[pole.length * 2];
	    System.arraycopy(pole, 0, polenove, 0, pole.length);
	    pole = polenove;
	}
	pole[pocet++] = cislo;
	pole[pocet++] = 1;
    }
    public int[] seznamCisel() {
	int ret[] = new int[pocet / 2];
	for (int i = 0; i < pocet / 2; i++)
	    ret[i] = pole[2 * i];
	return ret;
    }
    public int cetnost(int cislo) {
	for (int i = 0; i < pocet; i += 2)
	    if (pole[i] == cislo)
		return pole[i + 1];
	return 0;
    }
}

