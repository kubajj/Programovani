package kubajj.lekce16;

import cz.alisma.alej.prog.pg16.QuadraticEquationGenerator;
import cz.alisma.alej.prog.pg16.QuadraticEquationPrinter;
 
public class Rovnice {
    public static void main(String[] args) {
        QuadraticEquationPrinter printer = new HtmlPrinter();
        // QuadraticEquationPrinter printer = new ScreenPrinter();
 
        QuadraticEquationGenerator.generate(10, printer);
    }
}