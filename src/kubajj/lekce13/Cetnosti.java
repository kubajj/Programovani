package kubajj.lekce13;

public class Cetnosti {
    private String pole[];
    private int pocet;
    public Cetnosti() { pocet = 0; }
    public void zapis(String slovo) {
	for (int i = 0; i < pocet; i += 2)
	    if (pole[i].equals(slovo)) {
		int cislo = Integer.parseInt(pole[i + 1]);
		cislo++;
		pole[i + 1] = "" + cislo;
		return;
	    }
	if (pocet == 0)
	    pole = new String[16];
	else if (pole.length == pocet) {
	    String polenove[] = new String[pole.length * 2];
	    System.arraycopy(pole, 0, polenove, 0, pole.length);
	    pole = polenove;
	}
	pole[pocet++] = slovo;
	pole[pocet++] = "1";
    }
    
    public String[] seznamSlov() {
	String ret[] = new String[pocet / 2];
	for (int i = 0; i < pocet / 2; i++)
	    ret[i] = pole[2 * i];
	return ret;
    }
    
    public int cetnost(String slovo) {
	for (int i = 0; i < pocet; i += 2)
	    if (pole[i].equals(slovo)) {
		int cislo = Integer.parseInt(pole[i + 1]);
		return cislo;
	    }
	return 0;
    }
}
