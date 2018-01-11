public class Graf {
    public static void opakujZnak(char znak, int kolikrat) {
        while (kolikrat > 0) {
            System.out.printf("%c", znak);
            kolikrat--;
        }
    }
     
    public static void main(String args[]) {
        int[] hodnoty = new int[50];
        int pocetHodnot = 0;
        int max = 0;
        java.util.Scanner sc = new java.util.Scanner(System.in);
        while (sc.hasNextInt()) {
            int cislo = sc.nextInt();
            if (cislo < 0) {
                continue;
            }
            hodnoty[pocetHodnot] = cislo;
            if (cislo > max) {
                max = cislo;
            }
             
            pocetHodnot++;
            if (pocetHodnot == hodnoty.length) {
                break;
            }
        }
         
        double prepocet = 60. / max;
         
        for (int i = 0; i < pocetHodnot; i++) {
            opakujZnak('#', (int) (hodnoty[i] * prepocet));
            System.out.println();
        }
    }
}