package kubajj.lekce21;

import java.io.IOException;
import java.io.PrintWriter;

public class Nasobky {
	public static void main(String[] args) throws IOException {
		PrintWriter writer = new PrintWriter("nasobky.txt");
		int radek = 1;
	    for (int i = 0; i < 1000; i += 3) {
	    	if (i + 3 > 1000) {
	    		writer.printf("%d", i);
	    	} else {
	    		writer.printf("%d,", i); 
	    	}
	        if (radek == 10) {
	        	writer.println();
	        	radek = 0;
	        }
	        radek++;
	    }
	    writer.close();
	}
}
