import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	// 상,하,좌,우
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static class Point implements Comparable<Point>{
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		char[][] MAP = new char[H][W];
		int[] start = new int[2];
		int[] des = new int[2];
		boolean findStart = false;
		for(int i = 0; i < H; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0; j < W; j++) {
				if(input[j] == 'C') {
					if(findStart) {
						des[0] = j; des[1] = i;
					}else {
						findStart = true;
						start[0] = j; start[1] = i;
					}
				}
				MAP[i][j] = input[j];
			}
		}
		int[][][] check = new int[H][W][4];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				Arrays.fill(check[i][j], Integer.MAX_VALUE);
			}
		}
		
		PriorityQueue<Point> pQueue = new PriorityQueue<>();
		pQueue.add(new Point(start[0], start[1], 4, 0));
		check[start[1]][start[0]][0] = 0;
		check[start[1]][start[0]][1] = 0;
		check[start[1]][start[0]][2] = 0;
		check[start[1]][start[0]][3] = 0;
		while(!pQueue.isEmpty()) {
			Point current = pQueue.poll();
			int x = current.x;
			int y = current.y;
			int dir = current.dir;
			int cnt = current.cnt;
			for(int i = 0; i < 4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				int ccnt = cnt;
				if(xx < 0 || xx >= W || yy < 0 || yy >= H) continue;
				if(MAP[yy][xx] == '*') continue;
				if(check[yy][xx][i] <= cnt) continue;
				
				if(dir != 4 && dir != i) {
					ccnt += 1;
				}
				check[yy][xx][i] = ccnt;
				pQueue.add(new Point(xx,yy,i,ccnt));
				
			}
			
		}
		
		int result = Integer.MAX_VALUE;
		for(int i = 0; i < 4; i++) {
			result = Math.min(check[des[1]][des[0]][i], result);
		}
		System.out.print(result);
	}
}
