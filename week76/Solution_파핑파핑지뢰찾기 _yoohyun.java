import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, result;
	static int[][] map;
	// 상,우상,우,우하,하,좌하,좌,좌상
	static int[] dx = {0,1,1,1,0,-1,-1,-1};
	static int[] dy = {-1,-1,0,1,1,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int test_case = Integer.parseInt(br.readLine());
		for(int t = 1; t <= test_case; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				char[] input = br.readLine().toCharArray();
				for(int j = 0; j < N; j++) {
					if(input[j] == '.') map[i][j] = -1;
					else map[i][j] = -2;
				}
			}
			// 지뢰가 0인 위치 찾기
			result = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == -2 || map[i][j] == 0) continue;
					if(isZero(j, i)) {
						bfs(i, j);
						result++;
					}
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == -1) result++;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	public static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {j, i});
		map[i][j] = 0;
		while(!queue.isEmpty()) {
			int[] loc = queue.remove();
			int x = loc[0];
			int y = loc[1];
			
			for(int k = 0; k < 8; k++) {
				int xx = x + dx[k];
				int yy = y + dy[k];
				if(xx < 0 || xx >= N || yy < 0 || yy >= N || map[yy][xx] != -1) continue;
				if(isZero(xx, yy)) {
					queue.add(new int[] {xx,yy});
				}
				map[yy][xx] = 0;
			}
		}
	}
	public static boolean isZero(int x, int y) {
		for(int k = 0; k < 8; k++) {
			int xx = x + dx[k];
			int yy = y + dy[k];
			if(xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
			if(map[yy][xx] == -2) return false;
		}
		return true;
	}
}
