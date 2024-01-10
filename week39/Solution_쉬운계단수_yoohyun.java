import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	
	static int[][] dp;
	static final int MOD = 1000000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[101][10];
		for(int i = 0; i <= 1; i++) {
			for(int j = 0; j <= 9; j++) {
				if(j == 0) continue;
				dp[i][j] = i;
			}
		}
		
		for(int i = 2; i <= 100; i++) {
			for(int j = 0; j <= 9; j++) {
				if(j - 1 >= 0) {
					dp[i][j] += (dp[i - 1][j - 1] % MOD); 
				}
				if(j + 1 <= 9) {
					dp[i][j] += (dp[i - 1][j + 1] % MOD); 
				}
			}
		}
		long result = 0;
		for(int i = 0; i <= 9; i++) {
			result += (dp[N][i] % MOD);
			result %= MOD;
		}
		System.out.print(result);
	}
}
