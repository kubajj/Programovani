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
	} 
    
}
