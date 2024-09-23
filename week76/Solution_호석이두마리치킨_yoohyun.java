import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main{
	static int MAX_VALUE = 100000000;
	static int[][] dp;
	static boolean[][] visited;
	static int N, M;
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());

    	dp = new int[N + 1][N + 1];
    	for(int i = 1; i <= N; i++) {
    		for(int j = 1; j <= N; j++) {
    			if(i == j) {
    				dp[i][j] = 0;
    			} else {
    				dp[i][j] = MAX_VALUE;
    			}
    		}
    	}
    	
    	int A, B;
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		A = Integer.parseInt(st.nextToken());
    		B = Integer.parseInt(st.nextToken());
    	
    		dp[A][B] = 1;
    		dp[B][A] = 1;
    	}
    	
    	floyd();

    	int[] result = {MAX_VALUE * 2, N + 1, N + 1};
    	int temp;
    	for(int i = 1; i <= N; i++) {
    		for(int j = i + 1; j <= N; j++) {
    			temp = getAccessibility(i, j);
    			
    			if(result[0] > temp) {
    				result[0] = temp;
    				result[1] = i;
    				result[2] = j;
    			}
    		}
    	}
    	System.out.print(result[1] + " " + result[2] + " " + result[0]);
	}
	public static void floyd() {
		for(int k = 1; k <= N; k++) {
    		for(int i = 1; i <= N; i++) {
    			for(int j = 1; j <= N; j++) {
    				dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
    			}
    		}
    	}
	}
	public static int getAccessibility(int targetA, int targetB) {
		int result = 0;
		
		for(int i = 1; i <= N; i++) {
			result += Math.min(dp[i][targetA], dp[i][targetB]);
		}
		
		return result * 2;
	}
}
