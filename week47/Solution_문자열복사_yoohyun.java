import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class Main{
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	String S = br.readLine();
    	String P = br.readLine();
    
    	System.out.print(S.equals(P) ? 1 : makeString(S, P));
	}
	public static int makeString(String S, String P) {
		int result = 0;
		int index = 0;
		int sSize = S.length(), pSize = P.length();
		while(index < pSize) {
			int max = 0;
			
			for(int i = 0; i < sSize; i++) {
				int cnt = 0;
				for(int j = index; j < pSize; j++) {
					if((i + cnt) >= sSize || S.charAt(i + cnt) != P.charAt(j)) break;
					cnt++;
				}
				max = Math.max(max, cnt);
			}
			index += max;
			result++;
		}
		return result;
	}
}
