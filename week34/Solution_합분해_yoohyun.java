import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	static final int MOD = 1000000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][K + 1];
        
        for(int i = 0; i <= N; i++) {
        	dp[i][1] = 1;
        }
        
        for (int i = 2; i <= K; i++) {
        	for(int j = 0; j <= N; j++) {
        		for(int k = 0; k <= j; k++) {
        			dp[j][i] += dp[j - k][i - 1];
            		dp[j][i] %= MOD;
        		}
        	}
        }
        System.out.println(dp[N][K]);
	}
}
