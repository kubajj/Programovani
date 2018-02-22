package kubajj.lekce5;

public class KvadratickaRovnice {
 	public static void main (String[] args){
          double a = Double.parseDouble(args[0]);
          double b = Double.parseDouble(args[1]);
          double c = Double.parseDouble(args[2]);
          double D = b * b - 4 * a * c ;
          double presnost = 0.00000001 ;
              if (D < -presnost) {
                     System.out.println("Kvadratická rovnice s těmito kořeny nemá řešení.\n");   
                } else {
                      if (D > - presnost && D < presnost) {
                              double X = -b / (2 * a);
                              System.out.printf("Kořen kvadratické rovnice je %f.\n ", X);
                      } else {
                              double X1 = (-b + Math.sqrt(D) )/ (2 * a);
                              double X2 = (-b - Math.sqrt(D) )/ (2 * a);
                              System.out.printf("Kořeny jsou %f a %f.\n", X1 , X2);
                      }
                }
  }         
}        
