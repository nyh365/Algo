import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            String[] lotto = new String[N];
            int[] lotto_m = new int[N];
            String[] answer = new String[M];
            int[] result = new int[M];
            int total = 0;

            for(int i = 0; i < N; i ++) {
                st = new StringTokenizer(br.readLine());
                lotto[i] = st.nextToken();
                lotto_m[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < M; i ++) {
                answer[i] = br.readLine();
            }

            for(int i = 0; i < N; i ++) {
                for(int j = 0; j < M; j++) {
                    boolean flag = true;

                    for(int k = 0; k < 8; k++) {
                        char c = lotto[i].charAt(k);
                        if( c != '*') {
                            if(answer[j].charAt(k) != c) {
                                flag = false;
                                break;
                            }
                       }
                    }

                    if(flag) {
                        if(result[j] == 0)
                            result[j] = lotto_m[i];
                        else
                            result[j] = -1;
                    }
                }
            }

            for(int i = 0; i < M; i ++) {
                if(result[i] != -1)
                    total += result[i];
            }
            System.out.println("#" + test_case + " " + total);
        }
    }
}
