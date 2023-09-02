class Solution {
    int[] dx = {0,-1};
    int[] dy = {-1, 0};
    final int MOD = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n + 1][m + 1];
        for(int[] loc : puddles){
            dp[loc[1]][loc[0]] = -1; 
        }
        dp[1][1] = 1;
        
        int xx, yy;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(dp[i][j] == -1) continue;
                for(int k = 0; k < 2; k++){
                   xx = j + dx[k]; yy = i + dy[k];
                   if(xx < 1 || yy < 1) continue;
                   if(dp[yy][xx] == -1) continue;
                   dp[i][j] += dp[yy][xx];
                   dp[i][j] %= MOD;
                }
            }
        }
        return dp[n][m];
    }
}
