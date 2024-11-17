import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dp = new int[1000001];
	static final int MAX = 1000000009;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		init();

		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			sb.append(dp[num]).append("\n");
		}

		System.out.print(sb);
	}

	static void init() {
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i <= 1000000; i++) {
			dp[i] = (dp[i] + dp[i - 1]) % MAX;
			dp[i] = (dp[i] + dp[i - 2]) % MAX;
			dp[i] = (dp[i] + dp[i - 3]) % MAX;
		}
	}
}
