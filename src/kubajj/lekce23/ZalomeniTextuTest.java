package kubajj.lekce23;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;
import static org.junit.Assert.*;

public class ZalomeniTextuTest {
	@Test
	public void pokus() {
		Scanner text = new Scanner("Tohle je dlouhy radek, co bude zalomen.\nDalsi dlouhy radek stejneho odstavce.\n\n\nDruhy\nodstavec\nje\nponekud\nprasteny.\n");
		assertEquals("Tohle je dlouhy radek, co\nbude zalomen. Dalsi\ndlouhy radek stejneho\nodstavce\n\nDruhy odstavec je ponekud\nprasteny.\n", 
				ZalomeniTextu.zalamovani(text));
	}
}
