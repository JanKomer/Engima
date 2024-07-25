package hr.jan.enigma;

public class Keyboard {
	public int forward(String letter) {
		int signal = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(letter);
		return signal;
	}
	
	public String backward(int signal) {
		String letter = String.valueOf("ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(signal));
		return letter;
	}
}
