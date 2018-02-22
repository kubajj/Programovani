package kubajj.lekce3;

public class Nasobilka {
 	public static void main (String[] args){ 
		for ( int a = 1; a <= 10; a++){
			for ( int b = 1; b <= 10; b++){
				int c = (a * b);
				if ((a < 10) && (b == 1)){
					System.out.print(" ");
				}
				System.out.print(c);
				if ( ( (b + 1) * a) < 10){
					System.out.print("   ");
				}
				if ( ( ( (b + 1) * a) >= 10) && ( (b + 1) * a) < 100) {
					System.out.print("  ");
				}
				if ( ( (b + 1) * a) == 100){
					System.out.print(" ");
				}
			}
		System.out.println();
		} 
	}
}
