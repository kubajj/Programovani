public class Soustavy {
    public static void main (String args[]){
	int cislo = Integer.parseInt(args[0]);
	int soustava = Integer.parseInt(args[1]);
	int vysledek = 0;
	int zbytekpodeleni = 0;
	int rad = 0;
        while (cislo > 0) {
	    zbytekpodeleni = (cislo % soustava);
	    cislo -= zbytekpodeleni;
	    cislo = cislo / soustava;
	    vysledek += zbytekpodeleni  * Math.pow(10, rad);
	    rad++;
	}
	System.out.printf("%d\n", vysledek);
    }
}
