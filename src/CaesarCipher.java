import java.io.PrintWriter;

public class CaesarCipher {

	public static void main(String[] args) {

		
		PrintWriter error = new PrintWriter(System.err, true);

		// This checks to make sure that there is a correct number of parameters
		if (args.length != 2) {
			error.println("Incorrect number of parameters");
			System.exit(2);
		} else {
			// If user enters in "encode"
			if (args[0].equals("encode")) {
				encode(args[1]);
				// If user enters "decode"
			} else if (args[0].equals("decode")) {
				decode(args[1]);
				// Error message is user enters invalid options
			} else {
				error.println("Valid options are \"encode\" or \"decode\"");
				System.exit(1);
			}
		}
	}// main

// This function (al2Num) converts a character into an integer

	public static int al2Num(char ch) {

		int original = (int) ch;
		int base = (int) 'a';

		int result = original - base;

		return result;
	}

//This function (num2Al)  converts an integer to a character

	public static char num2Al(int x) {

		int base = (int) 'a';

		char result = (char) (x + base);

		return result;
	}

//Function to encode 
	public static void encode(String str) {

		PrintWriter pen = new PrintWriter(System.out, true);
		for (int n = 0; n < 26; n++) {
			pen.print("n = " + n + ": ");

			for (int i = 0; i < str.length(); i++) {
				// integer value incremented by constant n
				int converted = (al2Num(str.charAt(i)) + n) % 26;

				char cyphered = num2Al(converted);
				pen.print(cyphered);
			}
			pen.println();
		}
	}// encode

//Function to decode     
	public static void decode(String str) {

		PrintWriter pen = new PrintWriter(System.out, true);
		for (int n = 0; n < 26; n++) {
			pen.print("n = " + n + ": ");

			for (int i = 0; i < str.length(); i++) {
				// integer value incremented by constant n
				int converted = (al2Num(str.charAt(i)) - n + 26) % 26;

				char cyphered = num2Al(converted);
				pen.print(cyphered);
			}
			pen.println();
		}
	}// decode
}
