import java.io.*;
import java.util.*;

public class Main {
	static char[] start, result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		result = br.readLine().toCharArray();
		start = new char[K];
		char c = 'A';
		for(int i = 0; i < K; i++) {
			start[i] = c++;
		}
		
		List<char[]> list = new ArrayList<>();
		int size = N;
		for(int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			--size;
			if(input[0] == '?') {
				break;
			}
			
			for(int j = 0; j < K - 1; j++) {
				if(input[j] == '-') {
					char tmp = start[j];
					start[j] = start[j + 1];
					start[j + 1] = tmp;
				}
			}
		}
		
		for(int i = 0; i < size; i++) {
			list.add(br.readLine().toCharArray());
		}
		
		for(int i = list.size() - 1; i >= 0; i--) {
			char[] s = list.get(i);
			for(int j = 0; j < K - 1; j++) {
				if(s[j] == '-') {
					char tmp = result[j];
					result[j] = result[j + 1];
					result[j + 1] = tmp;
				}
			}
		}	
		
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		for(int i = 0; i < K - 1; i++) {
			if(start[i] == result[i]) sb.append("*");
			else {
				if(flag == false) {
					flag = true;
					if(start[i] == result[i+1]) {
						sb.append("-");
					}
					else {
						sb = new StringBuilder();
						for(int j = 0; j < K - 1; j++) {
							sb.append("x");
						}
						break;
					}
				}
				else {
					flag = false;
					if(start[i] == result[i-1]) {
						sb.append("*");
					}
					else {
						sb = new StringBuilder();
						for(int j = 0; j < K - 1; j++) {
							sb.append("x");
						}
						break;
					}
				}
			}
		}
		System.out.println(sb);
	}
}
