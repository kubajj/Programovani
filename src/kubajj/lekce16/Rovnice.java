package src.kubajj.lekce16;

import cz.alisma.alej.prog.pg16.QuadraticEquationGenerator;
import cz.alisma.alej.prog.pg16.QuadraticEquationPrinter;

public class Rovnice {
    public static void main(String[] args) {
    	QuadraticEquationPrinter printer = null;
    	/*if (args.length > 0) {
			if (args[0].equals("html")) {
				printer = new HtmlPrinter();
			} else {
				printer = new ScreenPrinter();
			}
		}*/
    	printer = new HtmlPrinter();
 
        QuadraticEquationGenerator.generate(10, printer);
    }
}