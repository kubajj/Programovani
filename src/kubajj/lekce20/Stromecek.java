package kubajj.lekce20;

/*
|-- PseudoFork.java
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
            System.out.printf("%s%s\n", indent, f.getName()); 
            char znak;
        	if (vypsano < pocet) {
        		znak = '|';
        	} else {
        		znak = '`';
        	}
            if (f.isDirectory()) {            	
            	printFiles(f, indent + znak + "  " + znak + "  ");            	
            } 
            vypsano++;
        }
    }
}