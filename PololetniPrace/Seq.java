public class Seq {
    public static boolean isInteger(String s) {
	//zdroj: https://stackoverflow.com/questions/5439529/determine-if-a-string-is-an-integer-in-java
	try { 
	    Integer.parseInt(s); 
	} catch(NumberFormatException e) { 
	    return false; 
	} catch(NullPointerException e) {
	    return false;
	}    
	return true;
    }
    
    public static void main (String args[]) {
	java.util.Scanner sc = new java.util.Scanner(System.in);
	String pole[] = new String[5];
	int pocet = 0;
	for (String prvek: args) {
	    pole[pocet++] = prvek;
	}
	if (pocet == 0)
	    System.out.println("Nezadal jste zadny argument.\n");
	if (pocet == 1) {
	    if (isInteger(pole[0])) {
		int end = Integer.parseInt(pole[0]);
		for (int i = 1; i <= end; i++) {
		    System.out.printf("%d ", i);
		}
	    } else {
		return;
	    }
	} else if (pocet == 2) {
	   if (isInteger(pole[0])) {
	       int prvni = Integer.parseInt(pole[0]);
		if (isInteger(pole[1])) {
		    int druhy = Integer.parseInt(pole[1]); 
		    for (int od = prvni; od <= druhy; od++) {
			System.out.printf("%d ", od);
		    }
		} else {
		    return;
		}
	    } else {
		return;
	    }
	} else if (pocet == 3) {
	    if (isInteger(pole[0])) {
		int prvni = Integer.parseInt(pole[0]);
		if(isInteger(pole[1])) {
		    int druhy = Integer.parseInt(pole[1]);
		    if (isInteger(pole[2])) {
			int treti = Integer.parseInt(pole[2]);
			if (druhy >= 0) {			    
			    for (int od = prvni; od <= treti; od += druhy) {
				System.out.printf("%d ", od);
			    }
			} else {
			    for (int od = prvni; od >= treti; od += druhy) {
				System.out.printf("%d ", od);
			    }
			}
		    } else {
			return;
		    }
		} else {
		    return;
		}
	    } else if (pole[0].equals("-s")) {
		if (!isInteger(pole[2]))
		    return;
		boolean prvy = true;
		int treti = Integer.parseInt(pole[2]);
		for (int i = 1; i <= treti; i++) {
		    if (prvy) {
			System.out.printf("%d", i);
			prvy = false;
		    } else {
			System.out.printf("%s%d", pole[1], i);
		    }		    
		}
	    } else {
		return;
	    }
	} else if (pocet == 4) {
	    if (pole[0].equals("-s")) {
		if (isInteger(pole[2])) {
		    int treti = Integer.parseInt(pole[2]);
		    if (isInteger(pole[3])) {
			int ctvrty = Integer.parseInt(pole[3]);
			boolean prvy = true;
			for (int i = treti; i <= ctvrty; i++) {
			    if (prvy) {
				System.out.printf("%d", i);
				prvy = false;
			    } else {
				System.out.printf("%s%d", pole[1], i);
			    }	
			}
		    } else {
			return;
		    }
		} else {
		    return;
		}
	    } else {
		return;
	    }
	} else if (pocet == 5) {
	    if (pole[0].equals("-s")) {
		if (isInteger(pole[2])) {
		    int treti = Integer.parseInt(pole[2]);
		    if (isInteger(pole[3])) {
			int ctvrty = Integer.parseInt(pole[3]);
			if (isInteger(pole[4])) {
			    int paty = Integer.parseInt(pole[4]);
			    boolean prvy = true;
			    for (int i = treti; i <= paty; i += ctvrty) {
				if (prvy) {
				    System.out.printf("%d", i);
				    prvy = false;
				} else {
				    System.out.printf("%s%d", pole[1], i);
				}	
			    }
			} else {
			    return;
			}
		    } else {
			return;
		    }
		} else {
		    return;
		}
	    } else {
		return;
	    }
	} else {
	    return;
	}
	System.out.println();
    }
}
