import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());;
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");

            int K = Integer.parseInt(br.readLine());
            int arr[] = new int[(int)Math.pow(2, K) - 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(arr[arr.length / 2]).append("\n");

            for(int i = K - 2; i >= 0; i--) {
                for(int j = (int)Math.pow(2, i) - 1; j < arr.length; j += (int)Math.pow(2, i + 1)) {
                    if(j != arr.length / 2)

                        sb.append(arr[j]).append(" ");

                }

                sb.append("\n");

            }

        }
        System.out.print(sb);

    }
}
