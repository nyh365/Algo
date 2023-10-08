import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int[][] city;
	static boolean[][] visited;
	static int N, L, R;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		city = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0;
		while(solve()) {
			result++;
		}

		System.out.print(result);
	}
	
	public static boolean solve() {
		Queue<int[]> queue = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}
		
		int[] cur;
		int xx, yy, dis;
		int total = 0;
		LinkedList<int[]> loc = new LinkedList<>();
		boolean result = false;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j]) continue;
				total = 0;
				queue.add(new int[] {j,i});
				loc.clear();
				visited[i][j] = true;
				total += city[i][j];
				loc.add(new int[] {j,i});
				
				while(!queue.isEmpty()) {
					cur = queue.remove();
					
					for(int k = 0; k < 4; k++) {
						xx = cur[0] + dx[k];
						yy = cur[1] + dy[k];
						
						if(xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
						if(visited[yy][xx]) continue;
						
						dis = Math.abs(city[cur[1]][cur[0]] - city[yy][xx]);
						if(L > dis || dis > R) continue;
						visited[yy][xx] = true;
						queue.add(new int[] {xx,yy});
						total += city[yy][xx];
						loc.add(new int[] {xx,yy});
						result = true;
					}
				}
				total /= loc.size();
				while(!loc.isEmpty()) {
					cur = loc.remove();
					city[cur[1]][cur[0]] = total;
				}
			}
		}
		return result;
	}
}
