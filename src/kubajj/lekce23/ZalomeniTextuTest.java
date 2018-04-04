package kubajj.lekce23;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Scanner;

public class ZalomeniTextuTest {
	@Test
	public void pokus() {
		Scanner text = new Scanner("Tohle je dlouhy radek, co bude zalomen.\nDalsi dlouhy radek stejneho odstavce.\n\n\nDruhy\nodstavec\nje\nponekud\nprasteny.\n");
		assertEquals("Tohle je dlouhy radek, co\nbude zalomen. Dalsi\ndlouhy radek stejneho\nodstavce\n\nDruhy odstavec je ponekud\nprasteny.\n", 
				ZalomeniTextu.zalamovani(text));
	}
}
