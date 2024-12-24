import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int memo[] = new int[1000001];
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			int result = 1;
			for(int i = 1; i < (N + 1) / 2; i++) {
				int K = 0;
				for(int j = i; j <= (N + 1) / 2; j++) {
					K += j;
					if(K > N)
						break;
					if(K == N) { 
						result++;
						break;
					}
				}
				
			}
			sb.append(result);
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
