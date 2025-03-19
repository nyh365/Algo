import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int solution(int n, int[] money) {
        int coinType = money.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for(int i = 1; i <= coinType; i++) {
            for(int j = 1; j <= n; j++) {
                if(j >= money[i - 1]) {
                    dp[j] += dp[j - money[i - 1]];
                }
                dp[j] %= MOD;
            }
        }
        
        return dp[n];
    }
}
