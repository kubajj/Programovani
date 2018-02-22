package kubajj.lekce3;

public class Delitele{
	public static void main (String[] args){
		int a = Integer.parseInt(args[0]);
		for (int b = 1; b <= a; b++){
			if ((a % b) == 0){
				System.out.print(b);
				System.out.print(" ");
			}
		}
	}
}
