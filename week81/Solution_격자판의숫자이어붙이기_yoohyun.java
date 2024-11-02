import java.io.*;
import java.util.*;

class Solution{
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int[][] board;
	static HashSet<Integer> result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		board = new int[4][4];
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			result = new HashSet<Integer>();
			//격자판 입력받기
			for(int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 4; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					dfs(board[i][j] * (int) Math.pow(10, 6), 1, j, i);
				}
			}
			sb.append(result.size()).append("\n");
			result.clear();
		}
		System.out.println(sb);
	}
	public static void dfs(int num, int cnt, int x, int y) {
		if(cnt == 7) {
			result.add(num);
			return;
		}
		for(int k = 0; k < 4; k++) {
			int xx = x + dx[k];
			int yy = y + dy[k];
			if(xx >= 0 && xx < 4 && yy >=0 && yy < 4) {
				dfs(num + board[yy][xx] * (int) Math.pow(10, 6-cnt), cnt + 1, xx, yy);
			}
		}
	}
}
