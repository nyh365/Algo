import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<int[]>[][] map = new ArrayList[N + 1][N + 1];
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j <= N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		boolean[][] visited = new boolean[N + 1][N + 1];
		boolean[][] light = new boolean[N + 1][N + 1];
		
		int x, y, a, b;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
		
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			map[y][x].add(new int[] {a,b});
		}
		
		int result = 1;
		
		Queue<int[]> queue = new LinkedList<>();
		light[1][1] = true;
		
		int[] cur; 
		int xx; int yy;
		boolean flag = true;
		while(flag){
			flag = false;
			
			for(int i = 0; i <= N; i++) {
				Arrays.fill(visited[i], false);
			}
			
			visited[1][1] = true;
			queue.add(new int[] {1,1});
			
			while(!queue.isEmpty()) {
				cur = queue.remove();						
			
				for(int[] loc : map[cur[1]][cur[0]]) {
					if(light[loc[1]][loc[0]]) continue;
					flag = true;
					light[loc[1]][loc[0]] = true;
					result++;
				}
				
				for(int k = 0; k < 4; k++) {
					xx = cur[0] + dx[k];
					yy = cur[1] + dy[k];
					
					if(xx < 1 || xx > N || yy < 1 || yy > N) continue;
					
					if(visited[yy][xx]) continue;
					
					if(!light[yy][xx]) continue;
					
					visited[yy][xx] = true;
					queue.add(new int[] {xx,yy});
				}
			}
		}
		
		System.out.print(result);
	}
}
