import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            int N = Integer.parseInt(br.readLine());
            StringBuilder s = new StringBuilder();
            while(s.length()<N) 
                s.append(br.readLine().replace(" ", ""));
            
            for(int i = 0; ; i++) {
                if(!s.toString().contains(String.valueOf(i))) {
                    sb.append(i).append("\n");
                    break;
                }
            }
            
        }
        System.out.println(sb);
    }
}
