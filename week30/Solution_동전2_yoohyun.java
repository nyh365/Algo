import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dp = new int[10001];
		int[] num = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for(int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(br.readLine());
			for(int j = 1; j <= 10000; j++) {
				if(j - num[i] > 0) {
					if(dp[j-num[i]] == Integer.MAX_VALUE) continue;
					dp[j] = Math.min(dp[j], dp[j - num[i]] + 1);
				} else if (j - num[i] == 0) {
					dp[j] = Math.min(dp[j], 1);
				}
			}
		}
		
		System.out.print(dp[K] == Integer.MAX_VALUE ? -1 : dp[K]);
	}
}
