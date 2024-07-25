package hr.jan.enigma;

public class Plugboard {
	String leftAlphabet;
	String rightAlphabet;
	StringWorker sw = new StringWorker();
	
	public Plugboard(String[] swappers) {
		super();
		this.leftAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		this.rightAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(String s : swappers) {
			leftAlphabet = StringWorker.swap(leftAlphabet, s);
		}
	}
	
	public int forward(int signal) {
		char letter = rightAlphabet.charAt(signal);
		int outputSignal = leftAlphabet.indexOf(letter);
		return outputSignal;
	}
	
	public int backward(int signal) {
		char letter = leftAlphabet.charAt(signal);
		int outputSignal = rightAlphabet.indexOf(letter);
		return outputSignal;
	}
	
	public void printAlphabets() {
		System.out.println("Left: " + leftAlphabet);
		System.out.println("Right: " + rightAlphabet);
	}
}
