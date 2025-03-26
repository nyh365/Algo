import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] dp = new int[N + 1][M + 1];
		for(int i = 0; i <= N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		dp[1][1] = 0;
		
		ArrayList<int[]>[] edges = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
			edges[b].add(new int[] {a, c});
		}

		for(int i = 2; i <= N; i++) {
			for(int[] food : edges[i]) {
				if(food[0] >= i) continue;
				
				for(int j = 0; j < M; j++) {
					if(dp[food[0]][j] != -1) {
						dp[i][j + 1] = Math.max(dp[i][j + 1], dp[food[0]][j] + food[1]);
					}
				}
			}
		}
		
		int result = 0;
		for(int i = 0; i <= M; i++) {
			if(dp[N][i] == -1) continue;
			result = Math.max(result, dp[N][i]);
		}
		
		System.out.print(result);
	}
}
