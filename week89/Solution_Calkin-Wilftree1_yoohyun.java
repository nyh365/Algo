import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int memo[] = new int[101];
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			String input = br.readLine();
			int up = 1;
			int down = 1;
			for(int i = 0; i < input.length(); i++) {
				
				if(input.charAt(i) == 'L') {
					down += up;
				}
				else
					up += down;
			}
			sb.append(up).append(" ").append(down).append("\n");
		}
		System.out.print(sb);
	}
}
