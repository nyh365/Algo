import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case);
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			for(int i = 1; i <= K; i++) {
				int tmp = 0, result = 0, cur = 0, cnt = 0;
				while(tmp + i <= N * K) {
					cur = cnt + i;
					cnt += K;
					tmp = cnt + (K -(i - 1));
					cnt += K;
					if(tmp <= N * K) {
						result += cur + tmp;
					}
					else {
						result += cur;
						break;
					}
				}
				sb.append(" ").append(result);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
