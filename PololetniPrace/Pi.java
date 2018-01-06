public class Pi {
    public static boolean jeVKruhu (int radek, int sloupec, int pocetcisel) {
	boolean je;
	if (Math.sqrt(radek * radek + sloupec * sloupec) <= pocetcisel) {
	    je = true;
	} else {
	    je = false;
	}
	return je;
    }
    
    public static void main(String[] args) {
	int polomer = Integer.parseInt(args[0]);
	double vkruhu = 0;
	double ctverec = 4 * polomer * polomer;
	for (int radek =  - polomer; radek < polomer; radek++) {
	    for (int sloupec = - polomer; sloupec < polomer; sloupec++) {
		if (jeVKruhu(radek, sloupec, polomer)) 
		    vkruhu++;		
	    }
	}
	double pi = (vkruhu * 4) / ctverec;
	System.out.printf("%f\n", pi);
    }
}
