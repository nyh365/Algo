import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[][] trees = new int[N + 1][N + 1];
        int[][][] dp = new int[N + 1][N + 1][2]; 
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                trees[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1][0] = trees[1][1];
        dp[1][1][1] = dp[1][1][0] + trees[1][1];

        for(int j = 2; j <= N; j++){
            dp[1][j][0] = dp[1][j - 1][0] + trees[1][j];
            dp[1][j][1] = Math.max(dp[1][j - 1][1] + trees[1][j], dp[1][j][0] + trees[1][j]);

            dp[j][1][0] = dp[j - 1][1][0] + trees[j][1];
            dp[j][1][1] = Math.max(dp[j - 1][1][1] + trees[j][1], dp[j][1][0] + trees[j][1]);
        }
        
        for(int i = 2; i <= N; i++){
            for(int j = 2; j <= N; j++){
                dp[i][j][0] = Math.max(dp[i - 1][j][0] + trees[i][j], dp[i][j - 1][0] + trees[i][j]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1] + trees[i][j], dp[i][j][0] + trees[i][j]);
                dp[i][j][1] = Math.max(dp[i][j][1], dp[i][j - 1][1] + trees[i][j]);
            }
        }
        
        System.out.print(dp[N][N][1]);
    }
}
