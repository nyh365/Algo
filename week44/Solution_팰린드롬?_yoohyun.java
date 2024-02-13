import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main{
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int N = Integer.parseInt(br.readLine());
    	int[] num = new int[N + 1];
    	boolean[][] dp = new boolean[N + 1][N + 1];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 1; i <= N; i++) {
    		num[i] = Integer.parseInt(st.nextToken());
    		dp[i][i] = true;
    		if(i != 1) {
    			dp[i - 1][i] = (num[i - 1] == num[i]);
    		}
    	}
    	
    	for(int i = 2; i < N; i++) {
    		for(int j = 1; j + i <= N; j++) {
    			dp[j][j + i] = (num[j] == num[j + i] && dp[j + 1][j + i - 1]);
    		}
    	}
    	
    	int M = Integer.parseInt(br.readLine());
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		sb.append(dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] ? 1 : 0).append("\n");
    	}
    	
    	System.out.print(sb);
    }
}
