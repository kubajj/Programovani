package kubajj.lekce24;

import java.io.PrintStream;

public class Zalamovac {
	private int maxSirka;
	private int sirka;
	private PrintStream vystup;

	public Zalamovac(int maxSirka, PrintStream vystup) {
		this.maxSirka = maxSirka;
		this.vystup = vystup;
		sirka = -1;
	}

	public void pridej(String slovo) {
		if (sirka + 1 + slovo.length() > maxSirka) {
			vystup.println();
			sirka = -1;
		} else {
			vystup.print(" ");
			sirka++;
		}
		vystup.print(slovo);
		sirka += slovo.length();
	}

	public void hotovo() {
		vystup.println();
		sirka = 0;
	}

}