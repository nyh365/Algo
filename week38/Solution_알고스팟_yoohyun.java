import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int[][] ROOM = new int[N][M];
		for(int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				ROOM[i][j] = input[j] -'0';
			}
		}
		
		boolean[][] check = new boolean[N][M];
		int result = -1;
		
		PriorityQueue<Point> pQueue = new PriorityQueue<>();
		pQueue.offer(new Point(0,0,0));
		check[0][0] = true;
		
		while(!pQueue.isEmpty()) {
			Point p = pQueue.remove(); 
			int x = p.x;
			int y = p.y;
			int crush = p.cnt;
			if(x == M -1 && y == N - 1) result = crush;
			for(int i = 0; i < 4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				
				if(xx < 0 || xx >= M || yy < 0 || yy >= N) continue;
				if(!check[yy][xx] && ROOM[yy][xx] == 0) {
					check[yy][xx] = true;
					pQueue.offer(new Point(xx,yy,crush));
				} 
				if(!check[yy][xx] && ROOM[yy][xx] == 1){
					check[yy][xx] = true;
					pQueue.offer(new Point(xx,yy,crush + 1));
				}
			}
		}
		System.out.println(result);
	}			
}
