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
			long N = Long.parseLong(br.readLine());
			long sum = ((N - 1) / 2) * ((N - 1) / 2); 
			sb.append(sum).append("\n");
		}
		System.out.print(sb);
	}
}
