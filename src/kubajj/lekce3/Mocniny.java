 public class Mocniny {
 	public static void main (String[] args){ 
		int a = Integer.parseInt(args[0]);
		for ( int b = 1; (b * b) < a; b++){
			System.out.print(b);
			System.out.print(" ");
		}
		System.out.println();	
	}
} 
