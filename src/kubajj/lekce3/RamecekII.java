  public class RamecekII {
          public static void main (String[] args){
                int sirka = Integer.parseInt(args[0]);
                int vyska = Integer.parseInt(args[1]);
                int tloustka = Integer.parseInt(args[2]);
                for (int y = 0; y < vyska; y++)  {
                  for (int x = 0; x < sirka; x++)  {
                        if ((x >= tloustka ) && (x < sirka - tloustka) && (y >= tloustka) && (y < vyska - tloustka))  {
                              System.out.print(" ");
                       } else  {
                              System.out.print("X") ;
                       }
                  }
		System.out.println();
                }
               }
              }
