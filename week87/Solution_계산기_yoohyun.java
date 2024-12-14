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
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int result = 0;
			for(int i = 0; i < N; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp <= 1 || result <= 1)
					result += tmp;
				else
					result *= tmp;
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
