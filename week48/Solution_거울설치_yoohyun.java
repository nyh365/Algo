import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static class Point implements Comparable<Point>{
		int x, y, dir, cnt;

		public Point(int x, int y, int dir, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cnt, o.cnt);
		}
	} 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		char[][] HOUSE = new char[N][N];
		int[][] mirror = new int[N][N];
		int[] start = new int[2];
		
		boolean find = false;
		for(int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0; j < N; j++) {
				if(input[j] == '#' && !find) {
					start[0] = j; start[1] = i;
					find = true;
				}
				HOUSE[i][j] = input[j];
			}
			Arrays.fill(mirror[i], Integer.MAX_VALUE);
		}
		
		PriorityQueue<Point> pQueue = new PriorityQueue<>();
		pQueue.offer(new Point(start[0], start[1], -1, 0)); // dir은 이전 방향
		HOUSE[start[1]][start[0]] = '*';
		while(!pQueue.isEmpty()) {
			Point cur = pQueue.poll();
			
			if(HOUSE[cur.y][cur.x] == '#') {
				System.out.print(cur.cnt);
				break;
			}
			
			if(cur.dir == -1) {
				for(int i = 0; i < 4; i++) {
					int x = cur.x + dx[i];
					int y = cur.y + dy[i];
					if(x < 0 || x >= N || y < 0 || y >= N) continue;
					if(HOUSE[y][x] == '*') continue;
					if(HOUSE[y][x] == '!') {
						if(mirror[y][x] >= cur.cnt + 1) {
							if(i == 0 || i == 1) {
								pQueue.offer(new Point(x,y, 2, cur.cnt + 1));
								pQueue.offer(new Point(x,y, 3, cur.cnt + 1));
							} else {
								pQueue.offer(new Point(x,y, 0, cur.cnt + 1));
								pQueue.offer(new Point(x,y, 1, cur.cnt + 1));
							}
							pQueue.offer(new Point(x,y,i, cur.cnt));
						}
					} 
					mirror[y][x] = cur.cnt;
					pQueue.offer(new Point(x,y,i, cur.cnt));
				}
			} else {
				int x = cur.x + dx[cur.dir];
				int y = cur.y + dy[cur.dir];
				if(x < 0 || x >= N || y < 0 || y >= N) continue;
				if(HOUSE[y][x] == '*') continue;
				if(HOUSE[y][x] == '!') {
					if(mirror[y][x] >= cur.cnt + 1) {
						if(cur.dir == 0 || cur.dir == 1) {
							pQueue.offer(new Point(x,y, 2, cur.cnt + 1));
							pQueue.offer(new Point(x,y, 3, cur.cnt + 1));
						} else {
							pQueue.offer(new Point(x,y, 0, cur.cnt + 1));
							pQueue.offer(new Point(x,y, 1, cur.cnt + 1));
						}
					}
				}
				mirror[y][x] = cur.cnt;
				pQueue.offer(new Point(x,y,cur.dir, cur.cnt));
			}
			
		}
	}
}
