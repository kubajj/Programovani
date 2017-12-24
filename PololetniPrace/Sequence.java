public class Sequence {
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
	    } else if (pole[0].equals("-s")) {
		System.out.println("Zapomnel jste zadat ostatni parametry.\n");
		System.out.println("Chcete je zadat?\n[A|N]\n");
		String odp = sc.next();
		if (odp.equals("N")) {
		    System.out.println("Nevadi.\nPreji hezky den.\n");
		    return;
		} else if (!odp.equals("A")) {
		    System.out.println("Nevidel jste nabidku?\nSpustte prosim program znovu.\n");
		    return;
		} else if (odp.equals("A")) {
		    System.out.println("Co chcete vkladat jako oddelovac misto mezery?\n");
		    if (odp.equals("")) {
			System.out.println("Zadejte prosim alespon jeden znak.\n");
			odp = sc.next();
			pole[1] = odp;
		    } else {
			odp = sc.next();
			pole[1] = odp;
		    }
		    System.out.println("Kolik dalsich parametru chcete zadat?\n[1|2|3]\n");
		    odp = sc.next();
		    if (Integer.parseInt(odp) > 3 || Integer.parseInt(odp) < 0) {
			System.out.println("To jste v nabidce nemel.\n");
			return;
		    } else if (Integer.parseInt(odp) == 1) {
			System.out.println("Vlozte prosim vas parametr.\n");
			odp = sc.next();
			if (isInteger(odp)) {
			    pole[2] = odp;
			} else {
			    System.out.println("Chyba!");
			    return;
			}
			int end = Integer.parseInt(pole[2]);
			boolean prvy = true;
			for (int i = 1; i <= end; i++) {
			    if (prvy) {
				System.out.printf("%d", i);
				prvy = false;
			    } else {
				System.out.printf("%s%d", pole[1] , i);
			    }
			}			
		    } else if (Integer.parseInt(odp) == 2) {
			System.out.println("Vlozte prosim vase parametry.\n");
			for (int i = 0; i <= 1; i++) {
			    odp = sc.next();
			    if (isInteger(odp)) {
				pole[i + 2] = odp;
			    } else {
				return;
			    }
			}
			int prvni = Integer.parseInt(pole[2]);
			int druhy = Integer.parseInt(pole[3]);
			boolean prvy = true;
			for (int od = prvni; od <= druhy; od++) {
			    if (prvy) {
				System.out.printf("%d", od);
				prvy = false;
			    } else {
				System.out.printf("%s%d", pole[1], od);
			    }
			}
		    } else if (Integer.parseInt(odp) == 3) {
			System.out.println("Vlozte prosim vase parametry.\n");
			for (int i = 0; i <= 2; i++) {
			    odp = sc.next();
			    if (isInteger(odp)) {
				pole[i + 2] = odp;
			    } else {
				System.out.println("Chyba!");
				return;
			    }
			}
			int prvni = Integer.parseInt(pole[2]);
			int druhy = Integer.parseInt(pole[3]);
			int treti = Integer.parseInt(pole[4]);
			boolean prvy = true;
			if (druhy >= 0) {			    
			    for (int od = prvni; od <= treti; od += druhy) {
				if (prvy) {
				    System.out.printf("%d", od);
				    prvy = false;
				} else {
				    System.out.printf("%s%d", pole[1] , od);
				}
			    }
			} else {
			    for (int od = prvni; od >= treti; od += druhy) {
				if (prvy) {
				    System.out.printf("%d", od);
				    prvy = false;
				} else {
				    System.out.printf("%s%d", pole[1] , od);
				}
			    }
			}
		    }
		}
	    }
		
	} else if (pocet == 2) {
	    if (pole[0].equals("-s")) {
		String oddelovac = pole[1];
		System.out.println("Zapomnel jste zadat cisla.\n");
		System.out.println("Chcete je zadat?\n[A|N]\n");
		String odp = sc.next();
		if (odp.equals("N")) {
		    System.out.println("Nevadi.\nPreji hezky den.\n");
		    return;
		} else if (!odp.equals("A")) {
		    System.out.println("Nevidel jste nabidku?\nSpustte prosim program znovu.\n");
		    return;
		} else if (odp.equals("A")) {
		    System.out.println("Kolik dalsich parametru chcete zadat?\n[1|2|3]\n");
		    odp = sc.next();
		    if (Integer.parseInt(odp) > 3 || Integer.parseInt(odp) < 0) {
			System.out.println("To jste v nabidce nemel.\n");
			return;
		    } else if (odp.equals("1")) {
			System.out.println("Vlozte prosim vas parametr.\n");
			odp = sc.next();
			if (isInteger(odp)) {
			    pole[1] = odp;
			} else {
			    System.out.println("Chyba!");
			    return;
			}
			int end = Integer.parseInt(pole[2]);
			boolean prvy = true;
			for (int i = 1; i <= end; i++) {
			    if (prvy) {
				System.out.printf("%d", i);
				prvy = false;
			    } else {
				System.out.printf("%s%d ", pole[1] , i);	
			    }
			}				
		    } else if (odp.equals("2")) {
			System.out.println("Vlozte prosim vase parametry.\n");
			for (int i = 0; i <= 1; i++) {
			    odp = sc.next();
			    if (isInteger(odp)) {
				pole[i + 1] = odp;
				pocet++;
			    } else {
				System.out.println("Chyba!");
				return;
			    }
			}
			int prvni = Integer.parseInt(pole[2]);
			int druhy = Integer.parseInt(pole[3]);
			boolean prvy = true;
			for (int od = prvni; od <= druhy; od++) {
			    if (prvy) {
				System.out.printf("%d ", od);
				prvy = false;
			    } else {
				System.out.printf("%s%d ", pole[1], od);
			    }
			}			
		    } else if (odp.equals("3")) {
			System.out.println("Vlozte prosim vase parametry.\n");
			for (int i = 0; i <= 2; i++) {
			    odp = sc.next();
			    if (isInteger(odp)) {
				pole[i + 2] = odp;
			    } else {
				System.out.println("Chyba!");
				return;
			    }
		        }
			int prvni = Integer.parseInt(pole[2]);
			int druhy = Integer.parseInt(pole[3]);
			int treti = Integer.parseInt(pole[4]);
			boolean prvy = true;
		        if (druhy >= 0) {			    
			    for (int od = prvni; od <= treti; od += druhy) {
				if (prvy) {
				    System.out.printf("%d ", od);
				    prvy = false;
				} else {
				    System.out.printf("%s%d ", pole[1] , od);
				}
			    }
			} else {
			    for (int od = prvni; od >= treti; od += druhy) {
				if (prvy) {
				    System.out.printf("%d ", od);
				    prvy = false;
				} else {
				    System.out.printf("%s%d ", pole[1] , od);
				}
			    }
			}
		    }
		}
	    } else if (isInteger(pole[0])) {
		int prvni = Integer.parseInt(pole[0]);
		if (isInteger(pole[1])) {
		    int druhy = Integer.parseInt(pole[1]); 
		    for (int od = prvni; od <= druhy; od++) {
			System.out.printf("%d ", od);
		    }
		} else {
		    System.out.println("Chyba!");
		    return;
		}		
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
			System.out.println("Chyba!");
			return;
		    }
		} else {
		    System.out.println("Chyba!");
		    return;
		}
	    } else if (pole[0].equals("-s")) {
		if (!isInteger(pole[2])) {
		    System.out.println("Chyba!");
		    return;
		}
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
		System.out.println("Chyba!");
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
			System.out.println("Chyba!");
			return;
		    }
		} else {
		    System.out.println("Chyba!");
		    return;
		}
	    } else {
		System.out.println("Chyba!");
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
			    System.out.println("Chyba!");
			    return;
			}
		    } else {
			System.out.println("Chyba!");
			return;
		    }
		} else {
		    System.out.println("Chyba!");
		    return;
		}
	    } else {
		System.out.println("Chyba!");
		return;
	    }
	} else {
	    System.out.println("Chyba!");
	    return;
	}
	System.out.println();
    }
}
