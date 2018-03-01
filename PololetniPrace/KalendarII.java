import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class KalendarII {
	public static class Mesic {
		private String jmeno;
		private int prvniDen;
		private int pocetDni;
		public Mesic(String jmeno, int prvniDen, int pocetDni) {
			this.jmeno = jmeno;
			this.prvniDen = prvniDen;
			this.pocetDni = pocetDni;
		}

		public String[] tisk() {
			List<String> radky = new ArrayList<>();
			radky.add("+----------------------+");
			radky.add(String.format(String.format("| %%s%%%ds |", 20 - jmeno.length() ,jmeno, "")));
			radky.add("+----------------------+");
			radky.add("| Po Ut St Ct Pa So Ne |");
			int start = -prvniDen + 2;
			int naNovyRadek = (8 - prvniDen) % 7;
			for (int i = start; i < start + 42; i++) {
				if ((i > 0) && (i <= pocetDni)) {
					radek += String.format("%2d", i);
				} else {
					radek += "  ";
				}
			}
			radky.add("+----------------------+");			
			return radky.toArray(new String[0]);			
		}
	}

	public static final String[] NAZVY_MESICU = new String[] { "Leden", "Unor", "Brezen", "Duben", "Kveten", "Cerven",
			"Cervenec", "Srpen", "Zari", "Rijen", "Listopad", "Prosinec" };

	public static void main(String[] args) {
		Calednar dnes = Calendar.getInstance();

		Calendar predchozi = Calendar.getInstance();
		predchozi.set(Calednar.DAY_OF_MONTH, 1);
		predchozi.get(Calednar.DAY_OF_MONTH, -1);
		Mesic mesic = new Mesic(NAZVY_MESICU[dnes.get(Calendar.MONTH)],
				predchozi.get(Calendar.DAY_OF_WEEK),
				dnes.getActualMaximum(Calendar.DAY_OF_MONTH));
		String radky[] = mesic.tisk();
		for (String r : radky) {
			System.out.println(r);
		}
	}
}
