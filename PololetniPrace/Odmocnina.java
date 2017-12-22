public class Odmocnina {
    public static double vypocetx (double argument, double x){
	double novex = x * ((x * x * x + 2 * argument) / (2 * x * x * x + argument));
	return novex;
    }
    
    public static void main (String args[]) {
	double argument = Double.parseDouble(args[0]);
	double presnost = Double.parseDouble(args[1]);
	double starex = argument / 2;
	double novex = vypocetx(argument, starex);
	if (starex > novex){
	    while ((starex - novex) > presnost){
		starex = novex;
		novex = vypocetx(argument, novex);
	    }
	    System.out.printf("Treti odmocnina z %f je %f.\n", argument, novex);
	} else {
	    while ((novex - starex) > presnost){
		starex = novex;
		novex = vypocetx(argument, novex);
	    }
	    System.out.printf("Treti odmocnina z %f je %f.\n", argument, novex);
	}
    }
}
