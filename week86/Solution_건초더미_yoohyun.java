import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int sum = 0, result = 0;

            for(int i = 0; i < N; i ++) {
                arr[i] = Integer.parseInt(br.readLine());
                sum += arr[i];
            }

            sum /= N;

            for(int i = 0; i < N; i ++) {
                if(sum > arr[i])
                    result += sum - arr[i];
            }

            System.out.println("#" + test_case + " " + result);

        }
    }
}
