import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		result = 0;
		dfs(s,t);
		System.out.println(result);
	}
	public static void dfs(String s, String t) {
		if(s.length() == t.length()) {
			if(s.equals(t)) {
				result = 1;
			}
			return;
		} 
		
		if(t.charAt(0) == 'B') {
			dfs(s, new StringBuilder(t.substring(1)).reverse().toString());
		}
		if(t.charAt(t.length() - 1) == 'A') {
			dfs(s, t.substring(0, t.length() - 1));
		}
		
	};
}
