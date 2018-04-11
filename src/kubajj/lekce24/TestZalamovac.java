package kubajj.lekce24;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestZalamovac {
	@Test
	public void presne() {
		ByteArrayOutputStream vysledek
			= new ByteArrayOutputStream();
		Zalamovac zalam = new Zalamovac(10,
				new PrintStream(vysledek));
		
		zalam.pridej("0123456789");
		zalam.pridej("0123456789");
		zalam.hotovo();
		
		assertEquals("0123456789\n0123456789\n",
				vysledek.toString());
	}
	
	@Test
	public void dveSlova() {
		ByteArrayOutputStream vysledek
			= new ByteArrayOutputStream();
		Zalamovac zalam = new Zalamovac(11,
				new PrintStream(vysledek));
		
		zalam.pridej("01234");
		zalam.pridej("56789");
		zalam.pridej("12345");
		zalam.pridej("67890");
		zalam.hotovo();
		
		assertEquals("01234 56789\n12345 67890\n",
				vysledek.toString());
	}
}