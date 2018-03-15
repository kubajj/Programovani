package kubajj.lekce22;

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
    	int delitel = 0;
		return delitel;    	
    }   
    
    public static int gcd2(int a, int b) {
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
	} 
    
}
