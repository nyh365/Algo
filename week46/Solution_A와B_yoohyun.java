import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class Main{
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	String s = br.readLine();
    	String t = br.readLine();
    	
    	System.out.print(canMake(s, t) ? 1 : 0);
	}
	
	public static boolean canMake(String s, String t) {
		int sSize = s.length();
		int tSize = t.length() - 1;
		
		for(int i = tSize; i >= sSize; i--) {
			if(t.charAt(i) == 'A') {
				t = func1(t);
			} else {
				t = func2(t);
			}
		}
		return s.equals(t);
	}
	public static String func1(String t) {
		return t.substring(0, t.length() - 1);
	}
	public static String func2(String t) {
		return new StringBuilder(t.substring(0, t.length() - 1)).reverse().toString();
	}
}
