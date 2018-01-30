public class DenVRoce { 
	public static boolean rokJePrestupny(int rok) {
		    if ((rok % 400) == 0) {
		          return true;
		    } else if ((rok % 100) == 0) {
		          return false;
		    } else if ((rok % 4) == 0)  {
		          return true;
		    } else {
		    	  return false;
		    }
	}
   
  
	public static int pocetDniMesice(int mesice, int rok) {
		    //return 30 + ((mesice + (mesice >= 8 ? 1 : 0)) % 2) - (mesice == 2 ? (rokJePrestupny(rok) ? 1 : 2) : 0);
		   if (( mesice == 1) || ( mesice == 3) || (mesice == 5) || (mesice == 7) || (mesice == 8) || (mesice == 10) || (mesice == 12) ){
		            return 31;
		    } else if (mesice == 2) {
		          if (rokJePrestupny(rok)) {
		            return 29;
		        }else {
		            return 28;
		        }
		    } else {
		         return 30; 
		    }
	   }
   
	public static void main (String[] args){
		int rok = Integer.parseInt(args[0]);
		int mesic = Integer.parseInt(args[1]);
		int den = Integer.parseInt(args[2]);
		int denvroce = 0;
		if ((mesic > 12) || (mesic <= 0 )){
			System.out.printf("Rok ma 12 mesicu, ne %d.", mesic);
			return;
		}
		if ((rok < 1582) || (den <= 0)){
			System.out.println("Spatne zadani hodnot.");
			return;
		}
		for (int mesice = 1; mesice < mesic; mesice++)  {
			denvroce += pocetDniMesice(mesice, rok);
		} 
		if (den > pocetDniMesice(mesic, rok)){
			System.out.println("Tento mesic v tomto roce tolik dni nema.");
		} else {
			denvroce += den;
			System.out.printf("Tento den je %d. dnem roku %d.\n", denvroce, rok); 	
		}
	}
            
}      
            
            
           
