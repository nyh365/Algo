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
			long start = 0;
			long end = 1000000;
			long result = -1;
			while(start <= end) {
				long mid = (start + end) / 2;
				long find = mid * mid * mid;
				if(find < N)
					start = mid + 1;
				else if(find > N) {
					end = mid - 1;
				}
				else {
					result = mid;
					break;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
}
