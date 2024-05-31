import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main{
	public static final int MOD = 1000000; 
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] pwd = br.readLine().toCharArray();
        int N = pwd.length;
        int[] pass = new int[N + 1];
        int[] dp = new int[N + 1];
        for(int i = 1; i <= N; i++) {
        	pass[i] = pwd[i - 1] - '0'; 
        }
        
        dp[0] = 1; 
        dp[1] = (pass[1] == 0) ? 0 : 1;
        
        for(int i = 2; i <= N; i++) {
        	if(pass[i] == 0) {
        		if(pass[i - 1] == 1 || pass[i - 1] == 2) {
        			dp[i] = dp[i - 2];
        		} else {
        			break;
        		}
        	} else {
        		if((pass[i - 1] * 10 + pass[i]) >= 10 && (pass[i - 1] * 10 + pass[i]) <= 26) {
    				dp[i] = dp[i - 1];
    				dp[i] += dp[i - 2];
    			} else {
    				dp[i] = dp[i - 1];
    			}
        	}
        	dp[i] %= MOD;
        }
        
        System.out.print(dp[N] % MOD);
	}
}
