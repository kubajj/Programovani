public class Maximum{
	public static void main (String args[]){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int cislo;
		int maximum = 0;
		while (sc.hasNextInt()){
		cislo = sc.nextInt();
			if (cislo > maximum)
				maximum = cislo;
		}
		System.out.printf("Největší číslo je %d.", maximum);
	}
}
