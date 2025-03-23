import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		int max, min;
		
		dp[0] = 0;
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			max = 0;
			min = 10001;
			for(int j = i; j > 0; j--) {
				max = Math.max(max, arr[j]);
				min = Math.min(min, arr[j]);
				
				dp[i] = Math.max(dp[i], dp[j - 1] + max - min);
			}
		}

		System.out.print(dp[N]);
	}
}
