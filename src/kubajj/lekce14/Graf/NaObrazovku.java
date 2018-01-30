package Graf;

public class NaObrazovku implements KreslicGrafu {	
	
	private void polozka(int velikost, double prepocet) {
		Pomocne.opakujZnak('#', Math.round(velikost * prepocet));
		System.out.println();
	}

	@Override
	public void kresli(int[] hodnoty, int pocet) {
		int max = Pomocne.maximum(hodnoty, pocet);
		double prepocet = 60. / max;
		
		for (int i = 0; i < pocet; i++) {
			polozka(hodnoty[i], prepocet);
		}
		
	}

}
