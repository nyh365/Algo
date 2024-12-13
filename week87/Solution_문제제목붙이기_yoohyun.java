import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            boolean arr[] = new boolean[26];
            int N = Integer.parseInt(br.readLine());
            int count = 0;
            for(int i = 0; i < N; i++) {
                String s = br.readLine();
                arr[s.charAt(0) - 'A'] = true;
            }
            for(int i = 0 ; i < 26; i++) {
                if(!arr[i])
                    break;
                count++;
            }
                
            System.out.println("#" + test_case + " " + count);
        }
    }
}
