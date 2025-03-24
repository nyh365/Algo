import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static final int MOD = 1_000_000_000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		if(N == 1) {
			System.out.print(1);
			return;
		}
		
		int exp = findExp(N);
		
		int[] dp = new int[N + 1];
		Arrays.fill(dp, 1);
		
		for(int i = 1; i < exp + 1; i++) {
			for(int j = 1; j <= N; j++) {
				if(j >= Math.pow(2, i)) {
					dp[j] += dp[j - (int) Math.pow(2, i)];
					dp[j] %= MOD;
				}
			}
		}
		
		System.out.print(dp[N]);
	}
	public static int findExp(int N) {
		int exp = 0, num = 1;
		
		while(num <= N) {
			num *= 2;
			exp++;
		}
		
		return exp - 1;
	}
}
