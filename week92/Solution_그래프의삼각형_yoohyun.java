import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int line[][] = new int[N + 1][N + 1];
			int result = 0;
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				line[from][to] = 1;
				line[to][from] = 1;
			}
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++ ) {
					if(line[i][j] > 0) {
						for(int k = 1; k <= N; k++) {
							if(line[j][k] > 0 && line[k][i] > 0) {
								result++; 
							}
						}
					}
				}
			}
			
			sb.append(result / 6).append("\n");
		}
		System.out.print(sb);
	}
}
