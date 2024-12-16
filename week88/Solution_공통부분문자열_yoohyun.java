import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input1 = br.readLine().toCharArray();
        char[] input2 = br.readLine().toCharArray();
        
        int size1 = input1.length;
        int size2 = input2.length;
        
        int[][] dp = new int[size1 + 1][size2 + 1];
        
        int result = 0;
        for(int i = 1; i <= size1; i++) {
            for(int j = 1; j <= size2; j++) {
                if(input1[i - 1] == input2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        
        System.out.println(result);
    }
}
