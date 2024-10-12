import java.io.*;
import java.util.*;


class Solution{
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int[][] room;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++){
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			int max_result = Integer.MIN_VALUE;
			int max_index = -1;
			room = new int[N][N];
			result = new int[N * N + 1];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					dfs(i,j, 1, room[i][j]);
				}
			}
			for(int i = 0; i < result.length; i++) {
				if(max_result < result[i]) {
					max_result = result[i];
					max_index = i;
				}
			}
			
			sb.append(max_index).append(" ").append(max_result).append("\n");
		}
		System.out.println(sb);
	}
	public static void dfs(int i, int j, int count, int start) {
		for(int k = 0; k < 4; k++) {
			int x = j + dx[k];
			int y = i + dy[k];
			if(x >= 0 && y >= 0 && x < room.length && y < room.length) {
				if(room[i][j] + 1 == room[y][x]) {
					dfs(y, x, count + 1, start);
				}
			}
		}
		result[start]= Math.max(result[start], count);
	}
}
