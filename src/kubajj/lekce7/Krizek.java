package kubajj.lekce7;

public class Krizek {
	public static void opakujZnak(char znak, int pocet){
		while (pocet > 0){
			System.out.printf("%c", znak);
			pocet--;
		}
	}
	
	public static int velikostRamene(int velikost){
			if (velikost % 2 == 0){
				return (velikost/2);
			} else {
				if (velikost != 3){
					return (velikost - 2);
				}else {
					return 2;
				}
			}
	}
	
	
	public static void main (String[] args) {
		int velikost = Integer.parseInt(args[0]);	
		if (velikost < 3){
			System.out.println("Vami zadana velikost krize je prilis mala.");
		} else {	
			for (int radek = 1; radek <= velikost * 2 + velikostRamene(velikost); radek++){
				for (int sloupec = 1; sloupec <= velikost * 3; sloupec++){
					if (((radek <= velikost) && (sloupec > velikost) && (sloupec < 2 * velikost + 1))
					|| ((radek > velikost + velikostRamene(velikost)) && (sloupec > velikost) && (sloupec < 2 * velikost + 1))){
						opakujZnak('X', 1);
					} else {
						if ((radek > velikost) && (radek <= velikost + velikostRamene(velikost))){
							opakujZnak('X', 1);
						} else {
							opakujZnak(' ', 1);
						}
					}
				}
				System.out.println();
			}
		}	
	}
}
