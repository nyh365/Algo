import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());
        int result = (1 << 10) - 1;
        for(int t = 1; t <= test_case; t++) {
            sb.append("#").append(t).append(" ");
            int tmp = 0;
            long N = Integer.parseInt(br.readLine());
            int cnt = 0;
            while(result != tmp) {
                char[] input = String.valueOf(N * ++cnt).toCharArray();
                for(int i = 0; i < input.length; i++) {
                    tmp |= 1 << (input[i] - '0');
                }
            }
            sb.append(N*cnt).append("\n");
        }
        System.out.println(sb);
    }
}
