import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		int[] num = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		dp[1] = 1;
		for(int i = 2; i <= N; i++) {
			dp[i] = 1;
			for(int j = 1; j < i; j++) {
				if(num[j] > num[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int result = 0;
		for(int i = 1; i <= N; i++) {
			result = Math.max(result, dp[i]);
		}
		System.out.print(result);
	}
}
