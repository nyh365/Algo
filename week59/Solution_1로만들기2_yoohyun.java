import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int X = Integer.parseInt(br.readLine());
        
        int[][] dp = new int[X + 1][2];
        for(int i = 0; i <= X; i++) {
        	dp[i][0] = Integer.MAX_VALUE;
        }
        
        dp[0][0] = 0; dp[0][1] = 0; 
        dp[1][0] = 0; dp[1][1] = 0;
        
        for(int i = 2; i <= X; i++) {
        	if(i % 3 == 0 && dp[i][0] > dp[i / 3][0] + 1) {
        		dp[i][0] = dp[i / 3][0] + 1;
        		dp[i][1] = i / 3;
        	}
        	
        	if(i % 2 == 0 && dp[i][0] > dp[i / 2][0] + 1) {
        		dp[i][0] = dp[i / 2][0] + 1;
        		dp[i][1] = i / 2;
        	} 

        	if(dp[i][0] > dp[i - 1][0] + 1) {
        		dp[i][0] = dp[i - 1][0] + 1;
        		dp[i][1] = i - 1;
        	}
        }
        sb.append(dp[X][0]).append("\n");
        
        for(int temp = X; temp != 0; temp = dp[temp][1]) {
        	sb.append(temp).append(" ");
        }
        System.out.print(sb);
	}
}
