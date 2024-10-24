import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            long N = Long.parseLong(br.readLine());
            long prev = -1;
            while(N != prev) {
                prev = N;
                N = f(N);
            }
            
            sb.append(N).append("\n");
        }
        System.out.print(sb);
    }
    public static long f(long n) {
        long sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
