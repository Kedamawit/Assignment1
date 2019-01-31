import java.io.PrintWriter;

public class VigenereCipher {
	public static void main(String[] args) {

		PrintWriter pen = new PrintWriter(System.out, true);
		PrintWriter error = new PrintWriter(System.err, true);

		// This checks to make sure that there is a correct number of parameters
		if (args.length != 3) {
			error.println("Incorrect number of parameters");
			System.exit(2);
		} else {
			// If user enters in "encode"
			if (args[0].equals("encode")) {
				// If user enters in an empty string then the plaintext is printed
				if (args[2].equals("")) {
					pen.println(args[1]);
				} else {
					encode(args[1], args[2]);
				}

				// If user enters "decode"
			} else if (args[0].equals("decode")) {
				// If user enters in an empty string then the plaintext is printed
				if (args[2].equals("")) {
					pen.println(args[1]);
				} else {

					decode(args[1], args[2]);

				}
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

	// This function (num2Al) converts an integer to a character
	public static char num2Al(int x) {

		int base = (int) 'a';

		char result = (char) (x + base);

		return result;

	}

	// This function repeats the key until it has reached the same length as the
	// plaintext.
	public static String replicate(String text, String key) {

		int lenText = text.length();

		int lenKey = key.length();

		char[] repArray = new char[lenText];

		for (int i = 0; i < lenText; i++) {
			repArray[i] = key.charAt(i % lenKey);

		}
		// this turns an array into a string

		String repString = new String(repArray);

		return repString;

	}

	// Function to encode
	public static void encode(String text, String key) {

		PrintWriter pen = new PrintWriter(System.out, true);

		String repKey = replicate(text, key);

		for (int i = 0; i < text.length(); i++) {
			int shifted = (al2Num(text.charAt(i)) + al2Num(repKey.charAt(i))) % 26;

			pen.print(num2Al(shifted));

		}

		pen.println();

	}

	// Function to decode
	public static void decode(String text, String key) {

		PrintWriter pen = new PrintWriter(System.out, true);

		String repKey = replicate(text, key);

		for (int i = 0; i < text.length(); i++) {
			int shifted = ((al2Num(text.charAt(i)) - al2Num(repKey.charAt(i))) + 26) % 26;

			pen.print(num2Al(shifted));
		}
		pen.println();
	}
}
