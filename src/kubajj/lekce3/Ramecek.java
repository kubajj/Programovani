package kubajj.lekce3;

public class Ramecek {
          public static void main (String[] args){  
                int vnejsia = Integer.parseInt(args [0]);
		int vnejsib = Integer.parseInt(args [1]);
		int a = (vnejsia + 4);
		int b = (vnejsib + 4);
		int vypsano = 0;
		for (int c = 1; c <= 2; c++){
			for (int d = 1; d <= a; d++ ) {
				System.out.print("X");
				vypsano++;
				if (vypsano == a) {
					System.out.println();
					vypsano = 0;
				}
				
                     	}
   
		}
		for (int e = 1; e <= (b - 4) ; e++) {
			System.out.print("XX");
			for (int f = 1; f <= (a - 4); f++) {
				System.out.print(" ");
			}
			System.out.println("XX");
		}
		for (int g = 1; g <= 2; g++){
			for (int h = 1; h <= a; h++ ) {
				System.out.print("X");
				vypsano++;
				if (vypsano == a) {
					System.out.println();
					vypsano = 0;
				}
				
                     	}
   
		}
		

	   }
                
     }
