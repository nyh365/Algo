import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class Main{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[100];
        for(int i = 0; i < 100; i++) {
        	if(i >= 25) {
        		dp[i] = Math.min(dp[i - 25] + 1, dp[i - 1] + 1); 
        		dp[i] = Math.min(dp[i], dp[i - 10] + 1); 
        	} else if (i >= 10) {
        		dp[i] = Math.min(dp[i - 10] + 1, dp[i - 1] + 1);
        	} else {
        		dp[i] = i;
        	}
        }
        
        int testCase = Integer.parseInt(br.readLine());
        for(int t = 0; t < testCase; t++) {
        	long chocolate = Long.parseLong(br.readLine());
        	
        	int result = 0;
        	while(chocolate > 0) {
        		result += dp[(int)(chocolate % 100)];
        		chocolate /= 100;
        	}
        	sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}
