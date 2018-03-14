package calc;

public class Kalkulacka {
	public static void main(String[] args) {
		double prvni = Double.parseDouble(args[0]);
		double druhe = Double.parseDouble(args[2]);
		String operace = args[1];
		double vysledek;
		switch (operace) {
		case "+":
			vysledek = prvni + druhe;
			break;
		case "-":
			vysledek = prvni - druhe;
			break;
		case "*":
			vysledek = prvni * druhe;
			break;
		case "/":
			if (druhe == 0) {
				System.out.println("Nelze!");
				return;
			} else {
				vysledek = prvni / druhe;
			}
			break;
		default : 
			System.out.println("Něco se pokazilo!");
			return;
		}
		System.out.printf("%f %s %f = %f\n", prvni, operace, druhe, vysledek);
	}
}
