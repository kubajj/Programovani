public class Zaokrouhlovani {
    public static void main(String[] args) {
        /*
         * Zmente nasledujici na 2, 4 nebo 5 a pozorujte rozdily.
         * A hlavne: JE NEZAPOMENTE!
         */
        int kroku = 8;
        double zdibec = 1. / kroku;
        double cislo = 0.;
        for (int i = 0; i < 25 * kroku; i++) {
            if ((i % kroku) == 0) {
                double ocekavam = i / kroku;
                if (cislo == ocekavam) {
                    System.out.printf("==> %.0f je ok\n", cislo);
                } else {
                    System.out.printf("%20.16f != %20.16f\n", ocekavam, cislo);
                }
            }
            cislo += zdibec;
        }
    }
}