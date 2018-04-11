package kubajj.lekce24;

import java.util.Scanner;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestDetektorOdstavcu {
	@Test
	public void prazdno() {
		Scanner vstup = new Scanner("\n\n\n\n");
		DetektorOdstavcu det = new DetektorOdstavcu(vstup);
		
		assertFalse(det.hasNextParagraph());
	}
	
	@Test
	public void prazdnoNaZacatku() {
		Scanner vstup = new Scanner("\n\nPrvni odstavec\n");
		DetektorOdstavcu det = new DetektorOdstavcu(vstup);
		
		assertTrue(det.hasNextParagraph());
		Odstavec odst = det.nextParagraph();
		assertEquals("Prvni odstavec\n", odst.obsah());
		
		assertFalse(det.hasNextParagraph());
	}
	
	@Test
	public void prazdnoNaKonci() {
		Scanner vstup = new Scanner("Prvni odstavec\n\n\n\n");
		DetektorOdstavcu det = new DetektorOdstavcu(vstup);
		
		assertTrue(det.hasNextParagraph());
		Odstavec odst = det.nextParagraph();
		assertEquals("Prvni odstavec\n", odst.obsah());
		
		assertFalse(det.hasNextParagraph());
	}
	
	@Test
	public void dvaOdstavce() {
		Scanner vstup = new Scanner(
				"Prvni odstavec\nDruhy radek.\n\n\n"
				+ "Druhy odstavec.\nDruhy radek.\nTreti radek.\n");
		DetektorOdstavcu det = new DetektorOdstavcu(vstup);
		
		assertTrue(det.hasNextParagraph());
		Odstavec odst = det.nextParagraph();
		assertEquals("Prvni odstavec\nDruhy radek.\n", odst.obsah());
		
		assertTrue(det.hasNextParagraph());
		odst = det.nextParagraph();
		assertEquals("Druhy odstavec.\nDruhy radek.\nTreti radek.\n", odst.obsah());
		
		
		assertFalse(det.hasNextParagraph());
	}
}