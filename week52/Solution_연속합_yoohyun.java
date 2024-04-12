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
		
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N];
		dp[0] = num[0];
		for(int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i - 1] + num[i], num[i]);
		}
		int result = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			result = Math.max(result, dp[i]);
		}
		System.out.print(result);
	}
}
