public class TrojuhelnikIIa {
 	public static void main (String[] args){ 
		for (int a = 1; a <= 5; a++){
			for (int b = 5; b >= a; b = b - 1){ 
				System.out.print(" ");
				if (b == a){
					for (int c = 1; c <= b; c++){					
						System.out.print("X");
					}
				System.out.println();
				}
			}
		}
	}
}


