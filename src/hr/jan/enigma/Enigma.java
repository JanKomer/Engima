package hr.jan.enigma;

public class Enigma {
	Plugboard p;
	Keyboard k;
	
	//ROTORS
	Rotor I;
	Rotor II;
	Rotor III;
	Rotor IV;
	Rotor V;
	
	//REFLECTORs
	Reflector A;
	Reflector B;
	Reflector C;
	
	public Enigma(String[] swaps) {
		super();
		this.p = new Plugboard(swaps);
		this.k = new Keyboard();
		I = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'Q');
		II = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 'E');
		III = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", 'V');
		IV = new Rotor("ESOVPZJAYQUIRHXLNFTGKDCMWB", 'J');
		V = new Rotor("VZBRGITYUPSDNHLXAWMJQOFECK", 'Z');
		A = new Reflector("EJMZALYXVBWFCRQUONTSPIKHGD");
		B = new Reflector("YRUHQSLDPXNGOKMIEBFZCWVJAT");
		C = new Reflector("FVPJIAOYEDRZXWGCTKUQSBNMHL");
	}
	
	public String encipher(String letter) {
		if(letter.equals(" ") || letter.equals(".") || letter.equals(",") || 
				letter.equals("!") || letter.equals("?")) return letter;
		rotateRotors();
		
		int signal = k.forward(letter);
		signal = p.forward(signal);
		signal = III.forward(signal);
		signal = II.forward(signal);
		signal = I.forward(signal);
		signal = B.reflect(signal);
		signal = I.backward(signal);
		signal = II.backward(signal);
		signal = III.backward(signal);
		signal = p.backward(signal);
		String result = k.backward(signal);
		
		return result;
	}
	
	public void setKey(String key) {
		char[] keys = key.toCharArray();
		I.rotateToLetter(keys[0]);
		II.rotateToLetter(keys[1]);
		III.rotateToLetter(keys[2]);
	}

	public void rotateRotors() {
		if(II.leftAlphabet.charAt(0) == II.notch
				&& III.leftAlphabet.charAt(0) == III.notch) {
			I.rotate();
			II.rotate();
			III.rotate();
		}else if(II.leftAlphabet.charAt(0) == II.notch){
			I.rotate();
			II.rotate();
			III.rotate();
		}else if(III.leftAlphabet.charAt(0) == III.notch) {
			II.rotate();
			III.rotate();
		}else {
			III.rotate();
		}
	}

	public void setRings(int r1, int r2, int r3) {
		I.setRing(r1);
		II.setRing(r2);
		III.setRing(r3);
	}
	
	public void reset(String key) {
		setKey(key);
		I.notch = 'Q';
		II.notch = 'E';
		III.notch = 'V';
	}
}
