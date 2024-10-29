import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int result_max;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			char[] num = st.nextToken().toCharArray();
			int count = Integer.parseInt(st.nextToken());
			result_max = Integer.MIN_VALUE;
			dfs(count, 0, num);
			
			sb.append(result_max).append("\n");
		}
		System.out.print(sb);
	}
	static void swap(char[] num, int i, int j) {
		char tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}
	static void dfs(int cnt, int deep, char[] num) {
		if(cnt == 0) {
			result_max = Math.max(result_max, Integer.valueOf(String.valueOf(num)));
			return;
		}
		for(int i = deep; i < num.length; i++) {
			for(int j = i + 1; j < num.length; j++) {
					swap(num, i, j);
					dfs(cnt - 1, i, num);
					swap(num, i, j);
			}
		}
	}
}
