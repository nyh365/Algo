import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	P[i] = Integer.parseInt(st.nextToken());
        }
        
        int M = Integer.parseInt(br.readLine());
        
        String[][] dp = new String[M + 1][M + 1];
        for(int i = 0; i <= M; i++) {
        	Arrays.fill(dp[i], "-1");
        }
        dp[0][0] = "";
        String result = "";
        for(int i = 0; i < M; i++) {
        	for(int j = 0; j < M; j++) {
        		if("-1".equals(dp[i][j])) continue;
        		for(int k = 0; k < N; k++) {
        			if(j + P[k] > M) continue;
        			if(i != 0 && "0".equals(dp[i][j])) continue;
        			if((dp[i][j] + String.valueOf(k)).compareTo(dp[i + 1][j + P[k]]) > 0) {
        				dp[i + 1][j + P[k]] = dp[i][j] + String.valueOf(k);
        				if(result.length() > dp[i + 1][j + P[k]].length()) continue;
        				if(result.length() == dp[i + 1][j + P[k]].length() && result.compareTo(dp[i + 1][j + P[k]]) > 0) {
        					continue;
        				}
        				result = dp[i + 1][j + P[k]];
        			}
        		}
        	}
        }
        
        System.out.print(result);
    }
}
