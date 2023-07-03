import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		dp = new int[12];
		dp[0] = 1; dp[1] = 1;
		for(int i = 2; i <= 11; i++) {
			if(1 <= i) {
				dp[i] += dp[i - 1];
			}
			if(2 <= i) {
				dp[i] += dp[i - 2];
			}
			if(3 <= i) {
				dp[i] += dp[i - 3];
			}
		}
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N]).append("\n");
		}
		System.out.print(sb);
	}
}
