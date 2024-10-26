import java.util.*;
import java.io.*;

class Solution {
	static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			result = 0;
			boolean arr[][] = new boolean[N][26];
			for(int i = 0; i < N; i++) {
				String s = br.readLine();
				for(int j = 0; j < s.length(); j++) {
					arr[i][s.charAt(j) - 'a'] = true;
				}
			}
			dfs(arr, 0, N, new boolean[N]);
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
	public static void dfs(boolean[][] arr, int start, int N, boolean[] word) {
		if(start == N) {
			check(arr, word);
			return;
		}
		word[start] = true;
		dfs(arr, start + 1, N, word);
		word[start] = false;
		dfs(arr, start + 1, N, word);
	}
	public static void check(boolean[][] arr, boolean[] word) {
		boolean[] alp = new boolean[26];
		for(int i = 0; i < word.length; i++) {
			if(word[i]) {
				for(int j = 0; j < 26; j++) {
					if(arr[i][j]) {
						alp[j] = true;
					}
				}
			}
		}
		boolean flag = true;
		for(int i = 0; i < 26; i++) {
			if(!alp[i])
				flag = false;
		}
		if(flag)
			result++;
	}
}
