public class SloupcovyGraf {
    public static void vytisk(double jednotka, double cisla, int zacatek) {
	int cislo = (int)cisla;
	double height = cislo * jednotka;
	int vyska = (int)height;
	System.out.printf("<rect x=\"%d\" y=\"%d\" width=\"20\" height=\"%d\"\nfill=\"blue\" stroke=\"black\" stroke-width=\"2\"/>\n", zacatek, 110 - vyska, vyska);
    }
    
    public static void main (String args[]) {
        int[] hodnoty = new int[100];
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
	if (pocetHodnot == 0)
	    return;
	double jednotka = 100./max;
	System.out.println("<?xml version=\"1.0\"?>");
	System.out.println("<svg xmlns=\"http://www.w3.org/2000/svg\"");
	System.out.printf("width=\"%d\" height=\"120\"\n", pocetHodnot * 24 + pocetHodnot * 4);
	System.out.printf("viewBox=\"0 0 %d 120\">\n", pocetHodnot * 24 + pocetHodnot * 4);
	int zacatek = 10;
	String tisk = "";
	for (int x = 0; x < pocetHodnot; x++) {
	    vytisk(jednotka, hodnoty[x], zacatek);	      
	    zacatek += 25;
	}
	System.out.println("</svg>");
    }
}
