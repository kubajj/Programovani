public class Faktorial {
	public static void main (String[] args) {
		int cislo = Integer.parseInt(args[0]);		
		long faktorial = 1;
		for (int i = 1; i <= cislo; i++){
			faktorial *= i;	
		}	
		System.out.printf("%d\n",faktorial);
	}
}
