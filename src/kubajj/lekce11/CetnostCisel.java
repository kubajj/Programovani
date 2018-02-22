package kubajj.lekce11;

public class CetnostCisel {
    public static void main (String args[]){    
	Cetnosti cetnost = new Cetnosti();
        System.out.printf("Zadejte maximalne 500 cisel:\n");
        java.util.Scanner sc = new java.util.Scanner(System.in);
	while (sc.hasNextInt()) 
	    cetnost.zapocitej(sc.nextInt());
        int cetnosti[] = cetnost.seznamCisel();
	java.util.Arrays.sort(cetnosti);
	for (int i = 0; i < cetnosti.length; i++)
	    System.out.printf("%d jste zadal %d-krat.\n", cetnosti[i], cetnost.cetnost(cetnosti[i]));
    }
}
