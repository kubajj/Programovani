package kubajj.lekce22;

import java.io.IOException;

public class MathUtils {
    public static int min(int... numbers) {
    	int minimum = Integer.MAX_VALUE;
    	if (numbers.length == 0) {
    		throw new IllegalArgumentException("Musite neco zadat.");
    	}
    	for (int n : numbers) {
    		if (n < minimum) {
    			minimum = n;
    		}
    	}
    	return minimum;
    }
    
    public static int gcd(int... numbers) {
<<<<<<< HEAD
    	if (numbers.length == 0) {
    		throw new NumberFormatException("Musite ta cisla zadat.");
    	}
    	int delitel;
    	for (int pozice = 1; pozice < numbers.length; pozice++) {
    		numbers[0] = gcd2(numbers[0], numbers[pozice]);
    	}
    	return numbers[0];
    }   
    
    public static int gcd2(int a, int b) {
    	if (("" + a).equals("")) {
    		throw new NumberFormatException("Musite ta cisla zadat.");
    	}
    	if (b == 0) {
    		return a;
    	}  	
		if (a < 0)
	        return gcd(a * -1, b); //turns the first parameter to a positive if it's initally negative
	    if (b < 0)
	        return gcd(a, b * -1); //turns the second parameter to a positive if it's initally negative
	    if (b <= a && a % b == 0)
	        return b;
	    return gcd(b, a%b);		   //zavola znovu tuto funkci
=======
    	int delitel = 0;
    	for (int n = 0; n < numbers.length - 1; n++) {
    		numbers[n + 1] = gcd2(numbers[n], numbers[n + 1]);
    		delitel = numbers[n + 1];
    	}
		return delitel;    	
    }   
    
 // recursive implementation
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }

    // non-recursive implementation
    public static int gcd2(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }
    
	public static void gcd2() {
		throw new IllegalArgumentException();		
>>>>>>> 1f835b6e4ee80ff3a491e755100919841fe38673
	} 
    
}
