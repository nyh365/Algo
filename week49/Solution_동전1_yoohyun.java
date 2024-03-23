import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		dp = new int[K + 1];
		int[] num = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(br.readLine());
			for(int j = 1; j <= K; j++) {
				if(j > num[i]) {
					dp[j] += dp[j - num[i]];
				}
				else if(j == num[i]) {
					dp[j] += 1;
				}
			}
		}
		
		System.out.print(dp[K]);
	}
}
