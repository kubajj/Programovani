public class TrojuhelnikII {
 	public static void main (String[] args){ 
		int d = Integer.parseInt(args [0]);
		for (int a = 1; a <= d; a++){
			for (int b = d; b >= a; b = b - 1){ 
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


