public class Nasobky {
 	public static void main (String[] args){
		int vypsano = 1;
		for ( int a = 3; a <= 30; a = a + 3){
			System.out.print(a);
			System.out.print(" ");
			if (vypsano == 4){
				System.out.println();
				vypsano = 0;
			}
			vypsano++;
		}
	}
}
