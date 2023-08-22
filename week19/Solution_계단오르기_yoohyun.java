import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {	
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int[] stair = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		dp = new int[N + 1];
		dp[0] = stair[0];
		dp[1] = stair[1];
		if(N > 1)
			dp[2] = stair[1] + stair[2];
		for(int i = 3; i <= N; i++) {
			dp[i] = Math.max(stair[i] + stair[i - 1] + dp[i - 3], stair[i] + dp[i - 2]);
		}
		System.out.print(dp[N]);
	}
}
