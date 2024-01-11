import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	static int[] dx = {0, -1, -1};
	static int[] dy = {-1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N + 1][M + 1];
		int[][] dp = new int[N + 1][M + 1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				dp[i][j] = map[i][j];
				for(int k = 0; k < 3; k++) {
					int xx = j + dx[k];
					int yy = i + dy[k];
					if(xx < 1 || yy < 1 || xx > M || yy > N) continue;
					dp[i][j] = Math.max(dp[i][j], map[i][j] + dp[yy][xx]);
				}
			}
		}
		
		
		System.out.print(dp[N][M]);
	}
}
