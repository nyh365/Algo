import java.util.*;
import java.io.*;
import java.math.BigDecimal;
class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			BigDecimal A = new BigDecimal(st.nextToken());
			BigDecimal B = new BigDecimal(st.nextToken());
			
			sb.append(A.add(B)).append("\n");
		}
		System.out.print(sb);
	}
}
