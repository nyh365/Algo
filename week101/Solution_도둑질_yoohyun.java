class Solution {
    public int solution(int[] money) {
        int houseCnt = money.length;
        int[] dp = new int[houseCnt + 1];
        
        // 안털었을 때
        dp[1] = 0;
        for(int i = 2; i <= houseCnt; i++) {
            dp[i] = Math.max(dp[i - 2] + money[i - 1], dp[i - 1]);
        }
        
        // 털었을 때
        dp[1] = money[0];
        for(int i = 2; i <= houseCnt; i++) {
            if(i == houseCnt) {
                dp[i] = Math.max(dp[i], dp[i - 1]);
            } else {
                dp[i] = Math.max(dp[i], Math.max(dp[i - 2] + money[i - 1], dp[i - 1]));
            }
        }
        
        return dp[houseCnt];
    }
}
