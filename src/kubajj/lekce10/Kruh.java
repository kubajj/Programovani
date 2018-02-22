package kubajj.lekce10;

public class Kruh {
    /* Je bod na souřadnicích [x,y] v kruhu K([0,0], r=polomer)? */
    private static boolean vKruhu(int x, int y, int polomer) {
        return polomer*polomer > x*x + y*y;
    }
 
    public static void kresli(int polomer) {
        for (int y = -polomer; y <= polomer; y++) {
            for (int x = -polomer; x <= polomer; x++) {
                if (vKruhu(x, y, polomer)) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
 
    public static void ukaz(int polomer) {
        System.out.printf("==============================\n %d \n", polomer);
        kresli(polomer);
        System.out.printf("\n\n");
    }
 
    public static void main(String[] args) {
        ukaz(1);
        ukaz(5);
        ukaz(10);
    }
}