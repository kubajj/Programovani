package kubajj.lekce24;

import java.util.Scanner;

public class Odstavec {
	private String data;
	private Scanner vstup;
	
	public Odstavec(String odstavec) {
		data = odstavec;
		vstup = new Scanner(data);
	}
	
	public String obsah() {
		return data;
	}

	public boolean hasNextWord() {
		return vstup.hasNext();
	}

	public String nextWord() {
		return vstup.next();
	}

}