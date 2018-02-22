package kubajj.lekce12;

public class Morseovka{
  public static void main(String args[]) {
      char jedna[] = new char[] {'1', '9', 'A', 'E', 'G', 'J', 'K', 'N', 'Q', 'W', 'Y'};
      char dva[] = new char[] {'2', '8', 'C', 'D','I', 'P', 'R', 'U', 'X', 'Z'} ;
      char tri[] = new char[] {'3', '7', 'B', 'F', 'L', 'S', 'V'};
      char ctyri[] = new char[] {'4', '6', 'H'};
      char pet[]  = new char[] {'5'};
    int pocet = 0;    
    java.util.Scanner sc = new java.util.Scanner(System.in);
    String znak = " ";
    while( sc.hasNext()) {
	  znak = sc.next();
	  char znacek = znak.charAt(0);
	  int i = 0;
	  while (i < 11) {
	      if (znacek == jedna[i]) {
		    pocet++;
		    break;
	      }
	      if (i < dva.length && znacek == dva[i]) {
		    pocet = pocet + 2;
		    break;
	      }
	      if (i < tri.length && znacek == tri[i]) {
		    pocet = pocet + 3;
		    break;
	      }
	      if (i < ctyri.length && znacek == ctyri[i]) {
		    pocet = pocet + 4;
		    break;
	      }
	      if (i < pet.length && znacek == pet[i]) {
		    pocet = pocet + 5;
		    break;
	      } 
	      i++;		    
	 }
      }
      System.out.printf("%d\n", pocet);                           
     }
}
