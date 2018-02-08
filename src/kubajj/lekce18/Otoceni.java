package kubajj.lekce18;
import java.util.ArrayList;
import java.util.List;

public class Otoceni {
	public static void main(String args[]) {
        List<Integer> cisla = new ArrayList<Integer>();
        java.util.Scanner sc = new java.util.Scanner(System.in);
        while (sc.hasNextInt()) {  
        	cisla.add(sc.nextInt());
        }
        for (int pozice = cisla.size(); pozice > 0; pozice--) {
        	System.out.printf("%d ", cisla.get(pozice - 1));
        }        
    }
}
