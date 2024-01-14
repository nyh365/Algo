import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N + 1];
		
		int result = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N + 1][2];
		dp[1][0] = 1; dp[N][1] = 1;
		for(int i = 2; i <= N; i++) {
			dp[i][0] = 1;
			for(int j = 1; j < i; j++) {
				if(num[i] > num[j]) {
					dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
				}
			}
		}
		
		for(int i = N - 1; i >= 1; i--) {
			dp[i][1] = 1;
			for(int j = N; j > i; j--) {
				if(num[i] > num[j]) {
					dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			result = Math.max(result, dp[i][0] + dp[i][1] - 1);
		}
		System.out.print(result);
	}
}
