public class VypocetOdmocniny{
    public static double vypocetx (double argument, double x){
	double novex = (((argument / x) + x) / 2);
	return novex;
    }

    public static void main (String args[]){
	double argument = Double.parseDouble(args[0]);
	double presnost = Double.parseDouble(args[1]);
	double starex = argument / 2;
	double novex = vypocetx(argument, starex);
	if (starex > novex){
	    while ((starex - novex) > presnost){
		starex = novex;
		novex = vypocetx(argument, novex);
	    }
	    System.out.printf("Odmocnina z %f je %f.\n", argument, novex);
	} else {
	    while ((novex - starex) > presnost){
		starex = novex;
		novex = vypocetx(argument, novex);
	    }
	    System.out.printf("Odmocnina z %f je %f.\n", argument, novex);
	}
    }
}
