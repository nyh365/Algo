import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Main{
	static final int MAX_VALUE = Integer.MAX_VALUE;
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int V = Integer.parseInt(st.nextToken());
    	int E = Integer.parseInt(st.nextToken());
    	
    	int[][] dp = new int[V + 1][V + 1];
    	int from, to, cost;

    	for(int i = 0; i <= V; i++) {
    		Arrays.fill(dp[i], MAX_VALUE);
    	}
    	for(int i = 0; i < E; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		from = Integer.parseInt(st.nextToken());
    		to = Integer.parseInt(st.nextToken());
    		cost = Integer.parseInt(st.nextToken());
    		
    		dp[from][to] = cost;
    	}
    	
    	for(int k = 1; k <= V; k++) {
    		for(int i = 1; i <= V; i++) {
    			for(int j = 1; j <= V; j++) {
    				if(dp[i][k] == MAX_VALUE || dp[k][j] == MAX_VALUE) continue;
    				dp[i][j] = Math.min(dp[i][k] + dp[k][j], dp[i][j]);
        		}
    		}
    	}
    	
    	int result = Integer.MAX_VALUE;
    	for(int i = 1; i <= V; i++) {
    		if(dp[i][i] == Integer.MAX_VALUE) continue;
    		result = Math.min(result, dp[i][i]);
    	}
    	System.out.print(result == Integer.MAX_VALUE ? -1 : result);
    }
}
