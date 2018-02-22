import java.util.Calendar;

public class KalendarII {
	public static class Mesic {
		public Mesic(String jmeno, int prvniDen, int pocetDni) {
		
		}
		public String[] tisk() {
			return new String[] {
				"+----------------------+",
				"+----------------------+"
			};
		}
	}
	
	public static final String[] NAZVY_MESICU = new String[] {
			"Leden", "Unor", "Brezen", "Duben", "Kveten", "Cerven", "Cervenec", "Srpen",
			"Zari", "Rijen", "Listopad", "Prosinec" 
	};
	
	
	public static void main(String[] args) {
		Calednar dnes = Calendar.getInstance();
		
		Calendar predchozi = Calendar.getInstance();
		predchozi.set(Calednar.DAY_OF_MONTH, 1);
		predchozi.get(Calednar.DAY_OF_MONTH, -1);
		Mesic mesic = new Mesic(NAZVY_MESICU[predchozi.get(Calendar.DAY_OF_WEEK)]);
	}
}
