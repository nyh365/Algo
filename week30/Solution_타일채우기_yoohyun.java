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
		int[] num = new int[N + 1];
		dp[0] = 1;
		dp[1] = 0; 
		if(N > 1) {
			dp[2] = 3;
			num[2] = 3;
		}	
		
		for(int i = 4; i <= N; i += 2) {
			num[i] = 2;
		}
		
		for(int i = 3; i <= N; i++) {
			for(int j = 2; j <= i; j++) {
				dp[i] += dp[i - j] * num[j];
			}
		}
		System.out.print(dp[N]);
	}
}
