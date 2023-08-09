import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static class Point implements Comparable<Point>{
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
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
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		boolean[][] ROOM = new boolean[N][N];
		boolean[][] check = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0; j < N; j++) {
				if(input[j] == '1') ROOM[i][j] = true; //흰 방
			}
		}
		check[0][0] = true;
		PriorityQueue<Point> pQueue = new PriorityQueue<>();
		pQueue.offer(new Point(0, 0, 0));
		
		while(!pQueue.isEmpty()) {
			Point p = pQueue.poll();
			int x = p.x;
			int y = p.y;
			int cnt = p.cnt;
			
			if(x == N - 1 && y == N - 1) {
				System.out.println(cnt);
				break;
			}
			for(int i = 0; i < 4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				if(xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
				if(check[yy][xx]) continue;
				check[yy][xx] = true;
				if(ROOM[yy][xx]) {
					pQueue.offer(new Point(xx,yy,cnt));
				} else {
					pQueue.offer(new Point(xx, yy, cnt + 1));
				}
			}
		}
	}
}
