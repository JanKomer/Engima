package hr.jan.enigma;

public class Reflector {
	String leftAlphabet;
	String rightAlphabet;
	
	
	public Reflector(String rightAlphabet) {
		super();
		this.leftAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		this.rightAlphabet = rightAlphabet;
	}
	
	public int reflect(int signal) {
		char letter = rightAlphabet.charAt(signal);
		int outputSignal = leftAlphabet.indexOf(letter);
		return outputSignal;
	}
}
