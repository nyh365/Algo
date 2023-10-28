import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N + 1][N + 1];
		long[][] dp = new long[N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int tmp;
		dp[1][1] = 1;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				tmp = map[i][j];
				if(tmp == 0) continue;
				if(j + tmp <= N) {
					dp[i][j + tmp] += dp[i][j];
				}
				if(i + tmp <= N) {
					dp[i + tmp][j] += dp[i][j];
				}
			}
		}
		System.out.print(dp[N][N]);
	}
}
