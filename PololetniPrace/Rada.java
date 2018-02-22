import java.util.Arrays;

public class Rada {
	public static void main(String[] args) {
		int start = 1;
		int stop = 0;
		int krok = 1;
		String oddelovac = " ";
					
		if (args[0].equals("-s")) {
			if (args.length == 1) {
				System.out.println("Chyba!");
				return;
			}
			oddelovac = args[1];
			args = Arrays.copyOfRange(args, 2, args.length);
		}
		
		if (args.length == 1) {
			stop = Integer.parseInt(args[0]);
		} else if (args.length == 2) {
			start = Integer.parseInt(args[0]);
			stop = Integer.parseInt(args[1]);
		} else if (args.length == 3) {
			start = Integer.parseInt(args[0]);
			krok = Integer.parseInt(args[1]);
			stop = Integer.parseInt(args[2]);
		} else {
			System.out.println("Chyba!");
		}
		
		if (krok == 0) {
			//Nedela nic
		}else if (krok > 0) {
			for (int i = start; i <= stop; i += krok) {
				System.out.print(i);
				if (i + krok <= stop) {
					System.out.print(oddelovac);
				}
			}
		} else {
			for (int i = start; i >= stop; i += krok) {
				System.out.print(i);
				if (i + krok >= stop) {
					System.out.print(oddelovac);
				}
			}
		}
	}
}
