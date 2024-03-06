import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Main{
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int N = Integer.parseInt(br.readLine());
    	int[][] cost = new int[N + 1][3];
    	
    	for(int i = 1; i <= N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < 3; j++) {
    			cost[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}

    	int[][][] dp = new int[N + 1][3][3];
    	for(int i = 1; i <= N; i++) {
    		for(int j = 0; j < 3; j++) {
    			Arrays.fill(dp[i][j], 1000001);
    		}
    	}
    	for(int i = 0; i < 3; i++) {
    		dp[1][i][i] = cost[1][i];
    	}
    	
    	for(int i = 2; i <= N; i++) {
    		for(int k = 0; k < 3; k++) {
				for(int j = 0; j < 3; j++) {
					if(i == N && k == j) continue;
					if(k == 0) {
						dp[i][j][k] = Math.min(dp[i - 1][j][1], dp[i - 1][j][2]) + cost[i][k];
					} else if(k == 1) {
						dp[i][j][k] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + cost[i][k];
					} else {
						dp[i][j][k] = Math.min(dp[i - 1][j][0], dp[i - 1][j][1]) + cost[i][k];
					}
				}
			}
    	}
    	
    	int result = Integer.MAX_VALUE;
    	for(int i = 0; i < 3; i++) {
    		for(int j = 0; j < 3; j++) {
    			result = Math.min(result, dp[N][i][j]);
    		}
    	}
    	
    	System.out.print(result);
    }
}
