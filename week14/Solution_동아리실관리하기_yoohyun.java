import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static final int INF = 1000000007, CASE = 16;
    static int[][] dp;
    static int[] input;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++){
            input = charToInt(br.readLine().toCharArray());
            dp = new int[input.length][CASE];
            init();
            solve();
            sb.append("#").append(test_case).append(" ").append(result()).append("\n");
        }
        System.out.print(sb);
    }

    public static int[] charToInt(char[] input){
        int[] result = new int[input.length];
        for(int i = 0; i < result.length; i++){
            result[i] = input[i] - 'A';
        }
        return result;
    }

    public static void init(){
        int manager = 1 << input[0];
        for(int i = 1; i < CASE; i++){
            if((i & 1) <= 0) continue;
            if((manager & i) > 0){
                dp[0][i] = 1;
            }
        }
    }

    public static void solve(){
        for(int i = 1; i < input.length; i++){
            int manager = 1 << input[i];
            for(int today = 1; today < CASE; today++){
                if((today & manager) <= 0) continue;
                for(int yesterday = 1; yesterday < CASE; yesterday++){
                    if((today & yesterday) > 0) dp[i][today] += dp[i - 1][yesterday];
                    dp[i][today] %= INF;
                }
            }
        }
    }

    public static int result(){
        int result = 0;
        for(int i = 1; i < CASE; i++){
            result += dp[input.length - 1][i];
            result %= INF;
        }
        return result;
    }
}
