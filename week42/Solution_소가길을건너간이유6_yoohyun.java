import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Main{
	static boolean[][][][] grassland = new boolean[101][101][101][101];
	static boolean[][] cows = new boolean[101][101];
	static boolean[][] visited = new boolean[101][101];
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int N, K, R;
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	R = Integer.parseInt(st.nextToken());
    	
    	int fromX, fromY, toX, toY;
    	for(int i = 0; i < R; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		fromY = Integer.parseInt(st.nextToken());
    		fromX = Integer.parseInt(st.nextToken());
    		toY = Integer.parseInt(st.nextToken());
    		toX = Integer.parseInt(st.nextToken());
    	
    		grassland[fromY][fromX][toY][toX] = true;
    		grassland[toY][toX][fromY][fromX] = true;
    	}
    	
    	Queue<int[]> queue = new LinkedList<>();
    	for(int i = 0; i < K; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		fromY = Integer.parseInt(st.nextToken());
    		fromX = Integer.parseInt(st.nextToken());
    		
    		queue.add(new int[] {fromX, fromY});
    		cows[fromY][fromX] = true;
    	}
    	
    	int result = 0;
    	while(!queue.isEmpty()) {
    		result += bfs(queue.remove());
    	}
    	System.out.print(result / 2);
    }
	public static int bfs(int[] loc) {
		for(int i = 0; i <= N; i++) {
			Arrays.fill(visited[i], false);
		}
		
		Queue<int[]> queue = new LinkedList<>();
		int cnt = K - 1;
		
		queue.add(loc);
		visited[loc[1]][loc[0]] = true;
		while(!queue.isEmpty()) {
			int[] cur = queue.remove();
			
			int xx, yy;
			for(int i = 0; i < 4; i++) {
				xx = cur[0] + dx[i];
				yy = cur[1] + dy[i];
				
				if(xx < 1 || xx > N || yy < 1 || yy > N) continue;
				if(visited[yy][xx]) continue;
				if(grassland[cur[1]][cur[0]][yy][xx]) continue;
				
				if(cows[yy][xx]) cnt--;
				
				visited[yy][xx] = true;
				queue.add(new int[] {xx,yy});
			}
		}
		return cnt;
	}
}
