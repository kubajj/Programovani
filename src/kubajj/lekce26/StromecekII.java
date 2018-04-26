package kubajj.lekce26;

import java.io.File;

/*
`-- src
    +-- Cetnosti.java
    +-- Cisla.java
    +-- cz
    |    `-- alisma
    |         `-- alej
    |              `-- prog1
    |                   `-- stromecek
    |                        `-- Stromecek.java
    `-- Graf.java
 
*/

public class StromecekII {
	public static void main(String[] args) {	
		boolean onlydir = false; 
		if ((args.length > 0) && (args[args.length - 1].equals("-d"))) {
			onlydir = true;
		}	
		printFiles(new File("."), "", onlydir);
	}

	private static void printFiles(File dir, String indent, boolean onlydir) {
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			if (onlydir && !f.isDirectory()) {
				continue;
			}
			boolean last = i + 1 == files.length;
			String branch = last ? "  `--" : "  |--";
			String continuation = last ? "      " : "  |  ";

			System.out.printf("%s%s %s\n", indent, branch, f.getName());
			if (f.isDirectory()) {
				printFiles(f, indent + continuation, onlydir);
			}
		}
	}
}