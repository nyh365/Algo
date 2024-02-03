import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Main{
	static final int MAX_VALUE = Integer.MAX_VALUE;
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int N = Integer.parseInt(br.readLine());
    	int M = Integer.parseInt(br.readLine());
    	
    	int[][] dp = new int[N + 1][N + 1];
    	int from, to, cost;

    	for(int i = 0; i <= N; i++) {
    		Arrays.fill(dp[i], MAX_VALUE);
    		dp[i][i] = 0;
    	}
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		from = Integer.parseInt(st.nextToken());
    		to = Integer.parseInt(st.nextToken());
    		cost = Integer.parseInt(st.nextToken());
    		
    		dp[from][to] = Math.min(dp[from][to], cost);
    	}
    	
    	for(int k = 1; k <= N; k++) {
    		for(int i = 1; i <= N; i++) {
    			for(int j = 1; j <= N; j++) {
    				if(dp[i][k] == MAX_VALUE || dp[k][j] == MAX_VALUE) continue;
    				dp[i][j] = Math.min(dp[i][k] + dp[k][j], dp[i][j]);
        		}
    		}
    	}
    	
    	for(int i = 1; i <= N; i++) {
    		for(int j = 1; j <= N; j++) {
    			sb.append((dp[i][j] == MAX_VALUE ? 0 : dp[i][j]) + " ");
    		}
    		sb.append("\n");
    	}
    	
    	System.out.print(sb);
    }
}
