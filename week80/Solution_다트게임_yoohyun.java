import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			int total = 0;
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				
				for(int j = 10; j >= 1; j--) {
					if(X * X + Y * Y <= 20 * (11 - j) * 20 * (11 - j)) {
						total += j;
						break;
					}
				}
			}
			sb.append(total).append("\n");
		}
		System.out.print(sb);
	}
}
