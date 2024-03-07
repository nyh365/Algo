import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			if(palindrome(input, 0, input.length - 1)) {
				sb.append(0).append("\n");
			} else if(sPalindrome(input, 0, input.length - 1)) {
				sb.append(1).append("\n");
			} else {
				sb.append(2).append("\n");
			}
		}
		
		System.out.print(sb);
	}
	public static boolean palindrome(char[] s, int sIdx, int eIdx) {
		int start = sIdx;
		int end = eIdx;
		while(start < end) {
			if(s[start] != s[end]) {
				return false;
			} else {
				start++; end--;
			}
		}
		return true;  
	}
	public static boolean sPalindrome(char[] s, int sIdx, int eIdx) {
		int start = sIdx;
		int end = eIdx;
		while(start < end) {
			if(s[start] != s[end]) {
				if(start + 1 < end) {
					if(palindrome(s, start + 1, end) || palindrome(s, start, end - 1)) {
						return true;
					} else {
						return false;
					}
				} else {
					start++;
				}
			} else {
				start++; end--;
			}
		}
		return true;  
	}
}
