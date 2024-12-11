import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int[] clock = new int[N];
			int result = 0;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				clock[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0; i < N; i++) {
				int tmp = clock[i];
				while(clock[i] <= B + E) {
					if(clock[i] >= B - E) {
						result++;
						break;
					}
					clock[i] += tmp;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
