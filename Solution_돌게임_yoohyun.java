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
		//0은 상근, 1은 창영
		dp[1] = 0;
		for(int i = 2; i <= N; i++) {
			if(i > 1)
				dp[i] = 1 - dp[i - 1];
		}
        System.out.println(dp[N] == 1 ? "CY" : "SK");
	}
}
