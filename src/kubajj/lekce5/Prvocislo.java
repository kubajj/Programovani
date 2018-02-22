package kubajj.lekce5;

public class Prvocislo{
	public static void main (String args[]){
		int cislo = Integer.parseInt(args[0]);
			if (cislo <= 1){
				System.out.printf("%d neni prvocislo.\n", cislo);
			} else {
				for (int i = 2; i < (cislo / 2) + 1; i++){
					if ((cislo % i) == 0){
						System.out.printf("%d neni prvocislo a je delitelne cislem %d.\n", cislo, i);
						return;
					}
				}
				System.out.printf("%d je prvocislo.\n", cislo);
			}
	}
}		
