import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main{
	static final int MOD = 1000000003;
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int N = Integer.parseInt(br.readLine());
    	int K = Integer.parseInt(br.readLine());
    	
    	int[][] dp = new int[N + 1][N + 1];
    	for(int i = 1; i <= N; i++) {
    		dp[i][1] = i;
    		dp[i][0] = 1;
    	}
    	
    	for(int i = 2; i <= N; i++) {
    		for(int j = 2; j <= i / 2; j++) {
    			dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % MOD;
    		}
    	}
    	System.out.print(dp[N][K]);
    }
}
