package kubajj.lekce20;
/*
|-- PseudoFork.javaindent += "|";
|-- ch
|    `-- usi
|          `-- dag
|                `-- dislrunner
|                      |-- JavaProcessBuilder.java
|                      |-- Runner.java
|                      `-- SysUtils.java
`-- StartDiSL.java
*/
import java.io.File;
 
public class Stromecek {
    public static void main(String[] args) {
        printFiles(new File("."), "");
    }
 
    private static void printFiles(File dir, String indent) {
    	File[] files = dir.listFiles();
        int pocet = files.length;
        int vypsano = 0;        
        for (File f : files) {
        	char znak, indentniznak;
	    	if (vypsano < pocet - 1) {
	    		znak = '|';
	    		indentniznak = znak;
	    	} else {
	    		znak = '`';
	    		indentniznak = ' ';
	    	}
            System.out.printf("%s%c-- %s\n", indent, znak, f.getName()); 
            if (f.isDirectory()) {
            	String novyindent = indent + indentniznak;
            	int mezery = 3 + Math.min(f.getName().length() - 1, 2);
            	for (int i = mezery; i > 0; i--) {
            		novyindent += " ";
            	}
            	printFiles(f, novyindent);            	
            } 
            vypsano++;
        }
    }
}