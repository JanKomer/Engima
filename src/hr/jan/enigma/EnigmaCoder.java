package hr.jan.enigma;

import java.util.Scanner;

public class EnigmaCoder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter your super secret message that you'd like to encode:");
		String message = sc.nextLine();
		String[] swaps = {"AR", "GK", "OX"};
		Enigma e = new Enigma(swaps);
		
		e.setKey("DOG");
		e.setRings(1, 1, 2);
		
		String output = "";
		String[] s = message.split("");
		for(String s1 : s) {
			output = output + e.encipher(s1);
		}
		System.out.println("Your enciphered message reads: " + output);
	}

}
