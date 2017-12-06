public class Elipsa {
    public static boolean jeVElipse(double a, double b, double x, double y){
	return 1 > (((x / a) * (x / a)) + ((y / b) * (y / b)));
    }
    
    public static void main (String args[]) {
	int hlavni = Integer.parseInt(args[0]);  //velikost hlavni poloosy
	int vedlejsi = Integer.parseInt(args[1]);//velikost vedlejsi poloosy
	System.out.println();
	for (int y = vedlejsi; y >= - vedlejsi; y--) {
	    for (int x = hlavni; x >= - hlavni; x--) {
		if (jeVElipse(hlavni, vedlejsi, x, y)) {
		    System.out.print("X");
		} else {
		    System.out.print(" ");
		}	    
	    }
	    System.out.println();
	}
	System.out.println();
    }
}
