public class OtoceniIII{
  public static void main(String args[]) {
    PoleIntu pole = new PoleIntu();
    java.util.Scanner sc = new java.util.Scanner(System.in);
 
    while (sc.hasNextInt()) {
        pole.pridej(sc.nextInt());
    }
 
    for (int i = pole.delka() - 1; i >= 0; i--) {
        System.out.printf("%d%s", pole.prvek(i), i > 0 ? " " : "");
    }
 
    System.out.println();
  }
}
