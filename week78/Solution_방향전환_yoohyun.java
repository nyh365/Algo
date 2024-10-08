import java.io.*;
import java.util.*;

class Solution{
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			st = new StringTokenizer(br.readLine());
			int[] from = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			int[] to = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			result = Integer.MAX_VALUE;
			dfs(from[0], from[1], to, 1, 0);
			dfs(from[0], from[1], to, 0, 0);
			
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	public static void dfs(int x1, int y1, int[] to, int pre, int cnt) {
		if(x1 == to[0] && y1 == to[1]) {
			result = Math.min(result, cnt);
			return;
		}
		// 상하
		if(pre == 1) {
			if(x1 <= to[0]) {
				dfs(x1 + 1, y1, to, 0, cnt+1);
			}
			else {
				dfs(x1 - 1, y1, to, 0, cnt+1);
			}
		}
		else {
			if(y1 <= to[1]) {
				dfs(x1, y1 + 1, to, 1, cnt+1);
			}
			else {
				dfs(x1, y1 - 1, to, 1, cnt+1);
			}
		}
	}
}
