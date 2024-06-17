import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; dp[1] = 1;
        
        for(int i = 2; i <= N; i++) {
        	for(int j = 1; j <= (int) Math.sqrt(i); j++) {
        		dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
        	}
        }
        System.out.print(dp[N]);
	}
}
