import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class Main{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] man = new int[N + 1];
        int[] woman = new int[M + 1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
        	man[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= M; i++) {
        	woman[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(man);
        Arrays.sort(woman);
        
        int[][] dp = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++) {
        	for(int j = 1; j <= M; j++) {
        		if(i == j) {
        			dp[i][j] = dp[i - 1][j - 1] + Math.abs(man[i] - woman[j]);
        		} else if(i < j) {
        			dp[i][j] = Math.min(dp[i - 1][j - 1] + Math.abs(man[i] - woman[j]), dp[i][j - 1]);
        		} else {
        			dp[i][j] = Math.min(dp[i - 1][j - 1] + Math.abs(man[i] - woman[j]), dp[i - 1][j]);
        		}
        	}
        }
        
        System.out.print(dp[N][M]);
    }
}
