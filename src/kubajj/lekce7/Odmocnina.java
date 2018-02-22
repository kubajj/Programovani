package kubajj.lekce7;

public class Odmocnina {
    public static int cisloA(int argument) {
	int i = 1;
	int cislo = 1;
	while (i < argument) {
	    if ((((i*i) <= argument )) && (((i+1)*(i+1)) > argument )) {
	       cislo = i;
	       break;
	    } else {
		i++;
	    }
	}
	return cislo;
    }          

    public static void main (String[] args) {
	int argumentOdmocniny = Integer.parseInt(args[0]);		//argument odmocniny
	if (argumentOdmocniny < 0) {
	   System.out.println("Toto je az prilis komplexni priklad.");
	} else {
	    double a = cisloA(argumentOdmocniny);
	    double a1 = ((argumentOdmocniny/a) + a) / 2;
	        System.out.printf("%f\n", a);
		System.out.printf("%f\n", a1);
	
			
	}
    }	
}
