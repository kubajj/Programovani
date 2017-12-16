public class MorseovkaII{
    public static void main (String args[]){
	String morse[] = new String[] { "A", ".-", "B", "-...", "C", "-.-.",
					"D", "-..", "E", ".", "F" , "..-." , "G" ,"--." , "H" ,
					"...." ,"I" , ".." , "J" ,".---" , "K" , "-.-" ,"L" , ".-.." , "M" ,
					"--" , "N" , "-." ,"0" , "---" , "P" ,".--." , "Q" , "--.-" ,"R" , ".-." , "S" ,"..." , "T" , "-" ,
					"U" , "..-" , "V" ,"...-" , "W" , ".--" ,"X" , "-..-" , "Y" ,"-.--" , "Z" , "--.." ,"1" , ".----",  "2" ,
					"..---" , "3" , "...--" ,"4" , "....-" , "5" , "....." , "6", "-....", "7" , "--...", "8", "---.." , "9", "----.","0", "-----" };
	int tecek[] = new int[256];
	for (int i = 0; i < morse.length; i = i + 2) {
	    int c = java.lang.Character.getNumericValue(morse[i].charAt(0));
	    for (int j = 0; j < morse[i + 1].length(); ++j)
		if (morse[i + 1].charAt(j) == '.')
		    tecek[c]++;
	}
	java.util.Scanner sc = new java.util.Scanner(System.in);
	int pocet = 0;
        while( sc.hasNext()) {
	    int c = java.lang.Character.getNumericValue(sc.next().charAt(0));
	    if (c >= 0 && c < tecek.length)
		pocet += tecek[c];
	}
	System.out.printf("%d\n", pocet);
    }
}
