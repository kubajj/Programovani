package kubajj.lekce3;

public class Trojuhelnik {
 	public static void main (String[] args){ 
		int b = Integer.parseInt(args[0]);
		for (int a = 1; a <= b; a++){
				for (int c = 1; c <= a; c++){
				System.out.print("X");
				}	
			System.out.println();				
		}
	}
}
