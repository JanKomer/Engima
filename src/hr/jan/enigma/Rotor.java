package hr.jan.enigma;

public class Rotor {
	String leftAlphabet;
	String rightAlphabet;
	char notch;
	
	
	public Rotor(String rightAlphabet, char notch) {
		super();
		this.leftAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		this.rightAlphabet = rightAlphabet;
		this.notch = notch;
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
	
	public void rotate() {
		leftAlphabet = StringWorker.rotate(leftAlphabet);
		rightAlphabet = StringWorker.rotate(rightAlphabet);
	}
	
	public void rotateToLetter(char letter) {
		int n = leftAlphabet.indexOf(letter);
		for(int i = 0; i < n; i++) {
			leftAlphabet = StringWorker.rotate(leftAlphabet);
			rightAlphabet = StringWorker.rotate(rightAlphabet);
		}
	}
	
	public void printAlphabets() {
		System.out.println("Left: " + leftAlphabet);
		System.out.println("Right: " + rightAlphabet);
	}

	public void setRing(int n) {
		for(int i = 0; i < n - 1; i++) {
			this.leftAlphabet = StringWorker.rotateBackwards(leftAlphabet);
			this.rightAlphabet = StringWorker.rotateBackwards(rightAlphabet);
		}

		int notchN = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(this.notch);
		this.notch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt((notchN - (n - 1)) % 26);
	}
}
