import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			dp[i] = i;
			for(int j = 1; j <= (int) Math.floor(Math.sqrt(i)); j++) {
				int num = i - (int) Math.pow(j, 2);
				dp[i] = Math.min(dp[i], dp[num] + 1);
			}
		}	
		System.out.print(dp[N]);
	}
}
