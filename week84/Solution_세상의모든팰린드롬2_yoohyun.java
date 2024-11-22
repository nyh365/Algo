import java.util.*;
import java.io.*;

class Solution
{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");

            String input = br.readLine();
            String result = "Exist";

            for(int i = 0; i < input.length() / 2; i++) {
                char a = input.charAt(i);
                char b = input.charAt(input.length() - 1 - i);

                if(a == '*' || b== '*') break;
                if(a != b) result ="Not exist";
            }
            sb.append(result).append("\n");

        }

        System.out.print(sb);
    }
}

