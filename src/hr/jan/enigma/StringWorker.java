package hr.jan.enigma;

public class StringWorker {
	public static String swap(String str, String swap) {
		int idx1 = str.indexOf(swap.charAt(0));
		int idx2 = str.indexOf(swap.charAt(1));
        char[] ch = str.toCharArray();
        char temp = ch[idx1];
        ch[idx1] = ch[idx2];
        ch[idx2] = temp;
        return new String(ch);
    }
	
	public static String rotate(String str) {
		return (str.subSequence(1, str.length()) + String.valueOf(str.charAt(0)));
	}

	public static String rotateBackwards(String str) {
		return (String.valueOf(str.charAt(25)) + str.subSequence(0, str.length() - 1));
	}
}
