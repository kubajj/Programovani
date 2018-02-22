package kubajj.lekce14.Graf;

public class DoSVG implements KreslicGrafu {
	@Override	
	public void kresli(int[] hodnoty, int pocet) {
		int maxVyska = 200;
		int max = Pomocne.maximum(hodnoty, pocet);
		double prepocet = (double) (maxVyska) / max;
		 
        System.out.println("<?xml version=\"1.0\"?>");
        System.out.println("<svg xmlns=\"http://www.w3.org/2000/svg\"");
        System.out.printf("width=\"%d\" height=\"%d\" viewBox=\"0 0 %d %d\">\n",
                pocet * 30 + 10, maxVyska + 20,
                pocet * 30 + 10, maxVyska + 20);	
        for (int i = 0; i < pocet; i++) {
        	int vyska = (int)(hodnoty[i] * prepocet);
        	System.out.printf("<rect x=\"%d\" y=\"%d\" width=\"20\" height=\"%d\"",
                    i * 30 + 10, maxVyska - vyska + 10, vyska);
            System.out.println(" fill=\"blue\" stroke=\"black\" stroke-width=\"2\"/>");
        }
        System.out.println("</svg>");
	}

}
