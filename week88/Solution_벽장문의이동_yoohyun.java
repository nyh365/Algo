import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][][] dp;
    static int[] order;
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        int left = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());
        
        M = Integer.parseInt(br.readLine());
        dp = new int[M][N + 1][N + 1];
        
        order = new int[M];
        for(int i = 0; i < M; i++) {
            order[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j <= N; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
       
        System.out.println(dfs(0, left, right));
    }
    
    public static int dfs(int orderIdx, int left, int right) {
        if(orderIdx == M) return 0;
        
        dp[orderIdx][left][right] = Math.min(
                    Math.abs(left - order[orderIdx]) + dfs(orderIdx + 1, order[orderIdx], right),
                    Math.abs(right - order[orderIdx]) + dfs(orderIdx + 1, left, order[orderIdx]));
        
        return dp[orderIdx][left][right];
    }
}
