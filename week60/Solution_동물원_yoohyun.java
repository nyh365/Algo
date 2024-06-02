import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	static final int MOD = 9901;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//사자 배치를 안 할 경우 0, 왼쪽에 사자 1, 오른쪽에 사자 2
		int[][] dp = new int[N + 1][3];
		dp[1][0] = 1; dp[1][1] = 1; dp[1][2] = 1;
		
		for(int i = 2; i <= N; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
			dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
			dp[i][2] = dp[i - 1][0] + dp[i - 1][1];
			dp[i][0] %= MOD;
			dp[i][1] %= MOD;
			dp[i][2] %= MOD;
		}
		System.out.print((dp[N][0] + dp[N][1] + dp[N][2]) % MOD);
	}
}
