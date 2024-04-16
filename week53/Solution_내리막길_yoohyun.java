import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int M, N;
	static int[][] road, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		road = new int[M + 1][N + 1];
		dp = new int[M + 1][N + 1];
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				road[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(dp[i], -1);
		}
		dfs(1,1);
		System.out.print(dp[1][1]);
	}
	public static int dfs(int x, int y) {
		if(x == N && y == M) return 1;
			
		dp[y][x] = 0;
		for(int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if(xx < 1 || yy < 1 || xx > N || yy > M) continue;
			if(road[y][x] <= road[yy][xx]) continue;
			
			if(dp[yy][xx] != -1)
				dp[y][x] += dp[yy][xx];
			else {
				dp[y][x] += dfs(xx, yy);
			}
		}
		return dp[y][x];
	}
}
