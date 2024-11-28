import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			String input = br.readLine();
			int cur = input.charAt(0) -'0', need = 0;
			for(int i = 1; i < input.length(); i++) {
				int tmp = input.charAt(i)-'0'; 
				if(tmp > 0) {
					if(cur < i) {
						need += i - cur;
						cur += i - cur;
						
					}
					cur += tmp;
				}
			}
				
			sb.append(need).append("\n");
		}
		System.out.print(sb);
	}
}
