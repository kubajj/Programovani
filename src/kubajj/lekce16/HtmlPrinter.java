package kubajj.lekce16;

import cz.alisma.alej.prog.pg16.QuadraticEquationPrinter;

public class HtmlPrinter implements QuadraticEquationPrinter {
	public HtmlPrinter() {}
	@Override
	public void printEquation(int a, int b, int c, int x1, int x2) {
		if (a == 1) {
			System.out.printf("x<sup>2</sup> + %dx + %d = \n", b, c);	
		} else {
			System.out.printf("%dx<sup>2</sup> + %dx + %d = \n", a, b, c);		
		}
	}
}
