import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	
	static long[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp = new long[91][2];
		dp[1][0] = 0; dp[1][1] = 1;  
		for(int i = 2; i <= 90; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
			dp[i][1] = dp[i - 1][0];
		}		
		System.out.print(dp[N][0] + dp[N][1]);
	}
}
