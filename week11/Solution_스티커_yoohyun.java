import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int test_case = Integer.parseInt(br.readLine());
		for(int t = 1; t <= test_case; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] point = new int[2][N + 1];
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= N; j++) {
					point[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dp = new int[3][N + 1];
			dp[1][1] = point[0][1];
			dp[2][1] = point[1][1];
			for(int i = 2; i <= N; i++) {
				dp[0][i] = Math.max(dp[0][i - 1], Math.max(dp[1][i - 1], dp[2][i-1]));
				dp[1][i] = Math.max(dp[0][i-1] + point[0][i], dp[2][i-1] + point[0][i]);
				dp[2][i] = Math.max(dp[0][i-1] + point[1][i], dp[1][i-1]+ point[1][i]);
			}
			int result = Math.max(dp[0][N], Math.max(dp[1][N], dp[2][N]));
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
}
