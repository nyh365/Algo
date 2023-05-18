import java.io.*;
import java.util.*;

public class Main {
	static int[][] board ;
	static int[][][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int result = -1;
		board = new int[N][M];
		visited = new int[N][M][2];
		boolean flag = false;
		
		st = new StringTokenizer(br.readLine());
		int cy = Integer.parseInt(st.nextToken()) -1;
		int cx = Integer.parseInt(st.nextToken()) -1;
		Point current = new Point(cx, cy, 1);
		
		st = new StringTokenizer(br.readLine());
		cy = Integer.parseInt(st.nextToken()) -1;
		cx = Integer.parseInt(st.nextToken()) -1;
		Point exit = new Point(cx, cy, 1);
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Point> queue = new LinkedList<>();
		queue.add(current);
		visited[current.y][current.x][current.magic] = 0;
		while(!queue.isEmpty()) {
			Point p = queue.remove();
			int x = p.x;
			int y = p.y;
			int magic = p.magic;
			for(int i = 0; i < 4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
	
				if(xx < 0 || xx >= M || yy < 0 || yy >= N) continue;
				if(xx == exit.x && yy == exit.y) {
					flag = true;
					result = visited[y][x][magic] + 1;
					break;
				}
				if(visited[yy][xx][magic] != 0) continue;
				if(board[yy][xx] == 1) {
					if(magic == 0)
						continue;
					else {
						queue.add(new Point(xx,yy, magic - 1));
						visited[yy][xx][magic - 1] = visited[y][x][magic] + 1;
					}
				}
				else {
					queue.add(new Point(xx, yy, magic));
					visited[yy][xx][magic] = visited[y][x][magic] + 1;
				}
			}
			if(flag) break;
		}
		
		System.out.println(result);
		
	
	}
	static class Point{
		int x, y, magic;

		public Point(int x, int y, int magic) {
			super();
			this.x = x;
			this.y = y;
			this.magic = magic;
		}
	}
}
