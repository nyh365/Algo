import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[] wine = new int[N];
		for(int i = 0; i < N; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		dp = new int[N];
		dp[0] = wine[0];
		if(N > 1)
			dp[1] = wine[0] + wine[1];
		if(N > 2)
			dp[2] = Math.max(wine[1] + wine[2], Math.max(wine[0] + wine[1], wine[0] + wine[2]));
		for(int i = 3; i < N; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
		}
		int result = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			result = Math.max(result, dp[i]);
		}
		System.out.print(result);
	}
}
