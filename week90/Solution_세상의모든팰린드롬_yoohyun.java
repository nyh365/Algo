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
			String input = br.readLine();
			int size = input.length();
			String result = "Exist";
			for(int i = 0; i < size / 2; i++) {
				if(input.charAt(i) == input.charAt(size - 1 - i) || input.charAt(i) == '?' || input.charAt(size - 1 -i) == '?' )
					continue;	
				else
					result = "Not exist";
			}
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
}
