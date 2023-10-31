class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int col = land[0].length;
        int row = land.length;
        
        int[][] dp = new int[row][col];
        for(int i = 0; i < col; i++){
            dp[0][i] = land[0][i];
        }
        
        for(int i = 1; i < row; i++){
            for(int j = 0; j < col; j++){
                for(int k = 0; k < col; k++){
                    if(j == k) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + land[i][j]);
                }
            }
        }
        
        for(int i = 0; i < col; i++){
            answer = Math.max(answer, dp[row - 1][i]);
        }
        return answer;
    }
}
