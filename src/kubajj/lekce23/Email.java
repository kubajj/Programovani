package kubajj.lekce23;

import java.util.Scanner;

public class Email {
	public static void main (String[] args) {
		Scanner email = new Scanner(System.in);		
		while (email.hasNextLine()) {
			String[] radek = email.nextLine().split(":");
			if(radek[0].equals("Subject") || radek[0].equals("From")) {
				System.out.printf("%s je %s", radek[0], radek[1]);
			}
		}
		email.close();
	}	
}
