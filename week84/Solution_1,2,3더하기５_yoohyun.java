import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] dp = new int[1000001][4];
	static final int MAX = 1000000009;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		init();

		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			sb.append(((dp[num][1] + dp[num][2]) % MAX + dp[num][3]) % MAX).append("\n");
		}

		System.out.print(sb);
	}

	static void init() {
		dp[0][1] = 1;
		dp[1][1] = 1;
		dp[2][2] = 1;
		for(int i = 3; i <= 1000000; i++) {
			dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MAX;
			dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MAX;
			dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MAX;
		}
	}
}
