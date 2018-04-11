package kubajj.lekce24;

import java.util.Scanner;

public class DetektorOdstavcu {
	private Scanner vstup;
	private String prvniRadek;

	public DetektorOdstavcu(Scanner vstup) {
		this.vstup = vstup;
	}

	public boolean hasNextParagraph() {
		while (vstup.hasNextLine()) {
			String radek = vstup.nextLine();
			if (!radek.isEmpty()) {
				prvniRadek = radek;
				return true;
			}
		}
		return false;
	}

	public Odstavec nextParagraph() {
		String odstavec = prvniRadek;
		while (vstup.hasNextLine()) {
			String radek = vstup.nextLine();
			if (radek.isEmpty()) {
				break;
			}
			
			odstavec = odstavec + "\n";
			odstavec = odstavec + radek;
		}
		
		return new Odstavec(odstavec + "\n");
	}

}