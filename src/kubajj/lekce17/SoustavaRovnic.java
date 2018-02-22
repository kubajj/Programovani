package kubajj.lekce17;

import java.util.Scanner;

public class SoustavaRovnic {
    private static final double EPSILON = 0.0001;
    private static final boolean LADIM = false;
     
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.printf("Zadej 1 argument: pocet rovnic.\n");
            return;
        }
         
        int pocetRovnic = Integer.parseInt(args[0]);
        if (pocetRovnic <= 0) {
            System.out.printf("Chci alespon 1 rovnici.\n");
            return;
        }
         
        double[][] koeficienty = nactiKoeficienty(pocetRovnic);
        if (koeficienty == null) {
            return;
        }
         
        eleminace(koeficienty);
        zpetneDosazeni(koeficienty);
         
        for (int i = 0; i < pocetRovnic; i++) {
            if (jeNula(koeficienty[i][i])) {
                System.out.printf("x_%d e R\n", i + 1);
                continue;
            }
            System.out.printf("x_%d = %6.2f", i + 1, koeficienty[i][pocetRovnic]);
             
            for (int j = i + 1; j < pocetRovnic; j++) {
                if (!jeNula(koeficienty[i][j])) {
                    double hodnota = koeficienty[i][j];
                    if (hodnota > 0.) {
                        System.out.printf(" - ");
                    } else {
                        System.out.printf(" + ");
                    }
                    System.out.printf("%6.2f x_%d", Math.abs(hodnota), j + 1);
                }
            }
             
            System.out.println();
        }
         
    }
     
    private static double[][] nactiKoeficienty(int pocetRovnic) {
        double[][] koeficienty = new double[pocetRovnic][pocetRovnic + 1];
        Scanner vstup = new Scanner(System.in);
        for (int rovnice = 0; rovnice < pocetRovnic; rovnice++) {
            for (int i = 0; i < pocetRovnic + 1; i++) {
                if (!vstup.hasNextDouble()) {
                    System.out.printf("Malo cisel!\n");
                    return null;
                }
                koeficienty[rovnice][i] = vstup.nextDouble();
            }
        }
         
        return koeficienty;
    }
     
    private static void eleminace(double[][] matice) {
        int radek = 0;
        int sloupec = 0;
        while (radek < matice.length) {          
            int nenulovyRadek = radek;
             
            while (jeNula(matice[nenulovyRadek][sloupec])) {
                nenulovyRadek++;
                if (nenulovyRadek == matice.length) {
                    nenulovyRadek = radek;
                    sloupec++;
                    if (sloupec == matice.length) {
                        return;
                    }
                }
            }
             
            if (LADIM) {
                System.out.printf("radek = %d, sloupec = %d\n", radek, sloupec);
            }
             
            vymenRadky(matice, nenulovyRadek, radek);
            nasobRadek(matice, radek, 1. / matice[radek][sloupec]);
            for (int i = radek + 1; i < matice.length; i++) {
                odectiNasobekRadku(matice, i, radek, matice[i][sloupec]);
            }
             
            if (LADIM) {
                tiskni(matice);
            }
             
            radek++;
            sloupec++;
        }
    }
     
    private static void zpetneDosazeni(double[][] matice) {
        int radek = matice.length - 1;
        while (radek >= 0) {
            int sloupec = 0;
            while (jeNula(matice[radek][sloupec])) {
                sloupec++;
                if (sloupec == matice.length) {
                    break;
                }
            }
             
            if (LADIM) {
                System.out.printf("radek = %d, sloupec = %d\n", radek, sloupec);
            }
             
            for (int i = 0; i < radek; i++) {
                odectiNasobekRadku(matice, i, radek, matice[i][sloupec]);
            }
             
            if (LADIM) {
                tiskni(matice);
            }
             
            radek--;
        }
    }
     
    private static void vymenRadky(double[][] matice, int a, int b) {
        if (a == b) {
            return;
        }
        double[] pom = matice[a];
        matice[a] = matice[b];
        matice[b] = pom;
    }
     
    private static void nasobRadek(double[][] matice, int radek, double x) {
        for (int i = 0; i < matice[radek].length; i++) {
            matice[radek][i] *= x;
        }
    }
     
    private static void odectiNasobekRadku(double[][] matice, int menenyRadek, int druhyRadek, double x) {
        for (int i = 0; i < matice[menenyRadek].length; i++) {
            matice[menenyRadek][i] -= x * matice[druhyRadek][i];
        }
    }
     
    private static void tiskni(double[][] koeficienty) {
        System.out.printf("===================\n");
        for (int rovnice = 0; rovnice < koeficienty.length; rovnice++) {
            for (int i = 0; i < koeficienty[rovnice].length - 1; i++) {
                tiskniClen(koeficienty[rovnice][i], i == 0, i + 1);
            }
            System.out.printf(" =");
            tiskniClen(koeficienty[rovnice][koeficienty[rovnice].length - 1], true, -1);
            System.out.println();
        }
    }
     
    private static void tiskniClen(double hodnota, boolean prvni, int koefIndex) {
        boolean zaporne = hodnota < 0.;
        hodnota = Math.abs(hodnota);
         
        if (zaporne) {
            System.out.printf(" - ");
        } else if (prvni) {
            System.out.printf("   ");
        } else {
            System.out.printf(" + ");
        }
         
        System.out.printf("%6.2f", hodnota);
         
        if (koefIndex >= 0) {
            System.out.printf(" * x_%d", koefIndex);
        }
    }
     
    private static boolean jeNula(double x) {
        return (x > -EPSILON) && (x < EPSILON);
    }
}