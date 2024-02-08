import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] puzzle;
	static boolean[][] visited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int result = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		puzzle = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				puzzle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(j, i, 1, puzzle[i][j]);
				visited[i][j] = false;
				shape(j, i);
			}
		}
		System.out.println(result);
	}
	public static void dfs(int x, int y, int cnt, int total) {
		if(cnt == 4) {
			result = Math.max(result, total);
			return;
		}
		for(int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if(xx < 0 || xx >= M || yy < 0 || yy >= N || visited[yy][xx]) continue;
			visited[yy][xx] = true;
			dfs(xx, yy, cnt + 1, total + puzzle[yy][xx]);
			visited[yy][xx] = false;
		}
	}
	public static void shape(int x, int y) {
		if(x + 2 < M && y - 1 >= 0) {
			result = Math.max(result, puzzle[y][x] + puzzle[y][x + 1] + puzzle[y][x + 2] + puzzle[y - 1][x + 1]);
		}
		if(x + 2 < M && y + 1 < N) {
			result = Math.max(result, puzzle[y][x] + puzzle[y][x + 1] + puzzle[y][x + 2] + puzzle[y + 1][x + 1]);
		}
		if(x - 1 >= 0 && y + 2 < N) {
			result = Math.max(result, puzzle[y][x] + puzzle[y + 1][x] + puzzle[y + 2][x] + puzzle[y + 1][x - 1]);
		}
		if(x + 1 < M && y + 2 < N) {
			result = Math.max(result, puzzle[y][x] + puzzle[y + 1][x] + puzzle[y + 2][x] + puzzle[y + 1][x + 1]);
		}
	}
}
