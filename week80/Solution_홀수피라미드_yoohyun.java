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
			long left = 2 * (N - 1) * (N - 1) + 1;
			long right = left + 2 * (2 * N - 2);
			sb.append(left).append(" ").append(right).append("\n");
		}
		System.out.print(sb);
	}
}

