import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	
	static int[][] dp;
	static final int MOD = 10007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N + 1][10];
		for(int i = 0; i <= 9; i++) {
			dp[1][i] = 1; 
		}
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j <= 9; j++) {
				for(int k = 0; k <= j; k++) {
					dp[i][j] += (dp[i - 1][k] % MOD); 
				}
			}
		}
		int result = 0;
		for(int i = 0; i <= 9; i++) {
			result += (dp[N][i] % MOD);
			result %= MOD;
		}
		
		System.out.print(result);
	}
}
