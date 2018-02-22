package kubajj.lekce16;

import cz.alisma.alej.prog.pg16.QuadraticEquationPrinter;

public class ScreenPrinter implements QuadraticEquationPrinter {

	@Override
	public void printEquation(int a, int b, int c, int x1, int x2) {
		if (a == 1) {
			System.out.printf("x² + %dx + %d = \n", b, c);
		} else {
			System.out.printf("%dx² + %dx + %d = \n", a, b, c);
		}
	}
}
