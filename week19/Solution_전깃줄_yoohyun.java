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
		int[] num = new int[501];
		int[] realNum = new int[N];
		int[] dp = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			num[from] = to;
		}
		int cnt = 0;
		for(int i = 0; i <= 500; i++) {
			if(num[i] == 0) continue;
			realNum[cnt++] = num[i];
		}
		
		dp[0] = 1;
		int result = dp[0];
		for(int i = 1; i < N; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(realNum[j] < realNum[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				} 
			}
			result = Math.max(result, dp[i]);
		}
		System.out.print(N - result);
	}
}
