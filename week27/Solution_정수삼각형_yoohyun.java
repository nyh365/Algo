class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int row = triangle.length;
        
        int[][] dp = new int[row][];
        for(int i = 0; i < row; i++){
            dp[i] = new int[triangle[i].length];
        }
        
        dp[0][0] = triangle[0][0];
        
        int tmp = row - 1;
        for(int i = 0; i < tmp; i++){
            for(int j = 0; j < dp[i].length; j++){
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + triangle[i + 1][j]); 
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + triangle[i + 1][j + 1]);
            }
        }
        
        
        for(int i = 0; i < dp[tmp].length; i++){
            answer = Math.max(answer, dp[tmp][i]);
        }
        
        return answer;
    }
}
