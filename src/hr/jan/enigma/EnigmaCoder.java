package hr.jan.enigma;

import java.util.Scanner;

public class EnigmaCoder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Enigma.\n" + "Before use please read the README.md file.\n"
				+ "Setup is required before you can start encrypting and decrypting messages.\n"
				+ "Please enter the letters you would like to swap in the Plugboard, as pairs separated by spaces (AB CD EF):");
		String[] swaps = sc.nextLine().split(" "); // AR GK OX
		Enigma e = new Enigma(swaps);

		System.out.println("Please enter the Key of your encrpted message:");
		String key = sc.nextLine();
		e.setKey(key); // DOG

		System.out.println("Please enter the offset of your rings, as numbers separated by a space (1 1 2).\n"
				+ "Note-Numbers can only be between 1 and 26, with 1 meaning no change in offset of rings.\n"
				+ "Enter numbers here:");
		String[] numbers = sc.nextLine().split(" ");
		e.setRings(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2]));

		System.out.println("Setup succesful! You may now enter messages to encipher them, or enter enciphered ones to decipher them.\n"
				+ "To exit the program, enter \\ESCAPE\\.");

		while (true) {
			System.out.print("Please enter your super secret message that you'd like to encode:");
			String message = sc.nextLine();
			message = message.toUpperCase();
			if (message.equals("\\ESCAPE\\"))
				break;
			String output = "";
			String[] s = message.split("");
			for (String s1 : s) {
				output = output + e.encipher(s1);
			}
			System.out.println("Your enciphered message reads: " + output);
			e.reset(key.toUpperCase());
			e.setRings(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2]));
		}

		System.out.println("Thank you for using Enigma. Have a nice day :)");
	}

}
