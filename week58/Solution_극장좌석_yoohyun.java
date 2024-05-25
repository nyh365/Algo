import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= N; i++) {
        	dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        int result = 1, length = 0;
        for(int i = 0; i < M; i++) {
        	int vip = Integer.parseInt(br.readLine());
        	result *= dp[vip - length - 1];
        	length = vip;
        }
        
        result *= dp[N - length];
        
        System.out.print(result);
	}
}
