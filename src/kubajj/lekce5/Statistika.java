package kubajj.lekce5;

public class Statistika {
    public static void main(String[] args) {
 	java.util.Scanner sc = new java.util.Scanner(System.in);
 		double sum = 0;//soucet
 		double min = 1.0/0.0;//minimum
 		double max = -1.0/0.0;//maximum
 		double ave = 0;//aritmeticky prumer
 		double sme;//smerodatna odchylka
 		int pocet = 0;//pocet cisel
 		double Xi = 0;//cisla na druhou
 		while (sc.hasNextDouble()){
 			 	double cislo = sc.nextDouble();
 			 	sum += cislo;
 			 	if (cislo < min)
 			 		min = cislo;
 			 	if (cislo > max)
 			 		max = cislo;
 			 	Xi += (cislo * cislo); 
 			 	pocet++;	
 		}
 		ave = sum / pocet;
 		sme = Math.sqrt((Xi - 2 * sum * ave + pocet * (ave * ave)) / pocet); 
 		System.out.printf("Součet je %f.\nAritmeticky prumer je %f.\nMinimum je %f.\nMaximum je %f.\nSměrodatná odchylka je %f.\n", sum, ave, min, max, sme);		   
    }
}
		
