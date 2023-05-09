import java.io.*;
import java.util.*;

public class Main {
	static int[][] space;
	static int N;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		space = new int[N][N];
		int result = 0, time = 0;
		int[] shark_s = new int[2];
		shark_s[0] = 2;
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> queue2 = new LinkedList<>();
		List<Point> fish = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if(space[i][j] == 9) {
					space[i][j] = 0;
					queue.add(j);
					queue.add(i);
				}
			}
		}
		
		boolean check[][] = new boolean[N][N];
		while(!queue.isEmpty()) {
			int x = queue.remove();
			int y = queue.remove();
			check[y][x] = true;
			for(int k = 0; k < 4; k++) {
				int xx = x + dx[k];
				int yy = y + dy[k];
				if(xx >= 0 && xx < N && yy >= 0 && yy < N && !check[yy][xx]) {
					if(space[yy][xx] == shark_s[0] || space[yy][xx] == 0) {
						queue2.add(xx);
						queue2.add(yy);
					}
					else if(space[yy][xx] < shark_s[0]) {
						fish.add(new Point(xx,yy));
					}
					check[yy][xx] = true;
				}
			}
			
			if(queue.isEmpty()) {
				time++;
				if(!fish.isEmpty()) {
					Collections.sort(fish);
					space[fish.get(0).y][fish.get(0).x] = 0;
					queue.add(fish.get(0).x);
					queue.add(fish.get(0).y);
					
					if(++shark_s[1] == shark_s[0]) {
						shark_s[0]++;
						shark_s[1] = 0;
					} 
					
					queue2.clear();
					fish.clear();
					check = new boolean[N][N];
					result += time;
					time = 0;
				}
				else {
					while(!queue2.isEmpty()) {
						queue.add(queue2.remove());
					}
				}
			}
			
		}
		System.out.println(result);
	}
}
class Point implements Comparable<Point>{
	int x;
	int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Point o) {
		if(this.y < o.y) return -1;
		else if(this.y == o.y) {
			if(this.x < o.x) return -1;
			else if(this.x == o.x) return 0;
			else return 1;
		}
		else return 1;
	}
}
