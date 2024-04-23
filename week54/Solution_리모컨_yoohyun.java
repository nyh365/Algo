import java.io.*;
import java.util.*;

public class Main {
	static boolean[] arr;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		arr = new boolean[11];
		
		
		if(M != 0) {
			st = new StringTokenizer(br.readLine(), " "); 
			for(int i = 0; i < M; i++)
				arr[Integer.parseInt(st.nextToken())] = true; 
		}
		
		int tmp = Math.abs(N-100);
		
		for(int i = 0; i < 1000000; i++) {
			int len = isVaildSize(i); 
			if(len >= 0) {
				int count = Math.abs(N - i) + len; 
				tmp = Math.min(count, tmp);
			}		
		}
		System.out.print(tmp);
	}
	public static int isVaildSize(int n) {
		String s = Integer.toString(n);
		for(int i = 0; i < s.length(); i++) {
			if(arr[s.charAt(i)-'0'])
				return -1;
		}
		return s.length();
	}
}
