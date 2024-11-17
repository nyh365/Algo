import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static final int MAX = 100000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N + 1];
		int[] dp = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++){
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.fill(dp, MAX);

		dp[1] = 0;
		for(int i = 1; i <= N; i++){
			if(dp[i] == MAX) continue;
			for(int j = 1; j <= num[i]; j++){
				if(i + j > N) break;

				dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
			}
		}
		System.out.print(dp[N] == MAX ? -1 : dp[N]);
	}
}
