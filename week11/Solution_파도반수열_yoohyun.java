import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	
	static long[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test_case = Integer.parseInt(br.readLine());
		
		dp = new long[100];
		dp[0] = 1; 
		dp[1] = 1; 
		dp[2] = 1;
		for(int i = 3; i < 100; i++) {
			dp[i] = dp[i - 2] + dp[i - 3];
		}
		
		for(int t = 1; t <= test_case; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N - 1]).append("\n");
		}
		System.out.print(sb);
	}
}
