package kubajj.lekce13;

public class CetnostSlov {
    public static void main (String args[]){    
	Cetnosti cetnost = new Cetnosti();
        System.out.printf("Zadejte vas text:\n");
        java.util.Scanner sc = new java.util.Scanner(System.in);
	while (sc.hasNext()) 
	    cetnost.zapis(sc.next());
        String cetnosti[] = cetnost.seznamSlov();
	for (int i = 0; i < cetnosti.length; i++)
	    System.out.printf("%s jste zadal %d-krat.\n", cetnosti[i], cetnost.cetnost(cetnosti[i]));
    }
}
