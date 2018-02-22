package kubajj.lekce7;

public class KombinacniCislo {
	public static double faktorial(int cislo){
	    if (cislo == 0){
		return 1;
	    } else {
		double faktorial = 1;
		for (int i = 1; i <= cislo; i++){
			faktorial *= i;	
		}	
		return faktorial;
	    }
	}
	
	public static void main (String[] args) {
	        int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		double kombinacnicislo = 0;
		if ((k > n) || (k < 0)) {
			System.out.println("Error...");
		} else {
		        kombinacnicislo =(faktorial(n)/ (faktorial(k)*faktorial(n-k)));
			if (kombinacnicislo == 1){
				System.out.printf("%d-prvkovou mnozinu lze z %d-prvkove mnoziny vypsat %f zpusobem.\n", k, n, kombinacnicislo);
			} else {
				System.out.printf("%d-prvkovou mnozinu lze z %d-prvkove mnoziny vypsat %f zpusoby.\n", k, n, kombinacnicislo);
			}
		}
	}	
}
