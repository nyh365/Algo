import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Main{
	static int[][] dp = new int[10001][4];
    public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();

    	int T = Integer.parseInt(br.readLine());
    	
    	init();
    	
    	for(int test_case = 0; test_case < T; ++test_case) {
    		int N = Integer.parseInt(br.readLine());
    		
    		sb.append(dp[N][1] + dp[N][2] + dp[N][3]).append("\n");
    	}
    	
    	System.out.print(sb);
    }
    public static void init() {
    	dp[1][1] = 1;
    	dp[2][1] = 1; dp[2][2] = 1;
    	dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;
    	for(int i = 4; i < 10001; i++) {
    		dp[i][1] = dp[i - 1][1];
    		dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
    		dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
    	}
    }
}
