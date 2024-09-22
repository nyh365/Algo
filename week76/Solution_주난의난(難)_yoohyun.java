import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main{
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static char[][] map;
	static boolean[][] visited;
	static int N, M;
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());

    	st = new StringTokenizer(br.readLine());
    	int y1 = Integer.parseInt(st.nextToken()) - 1;
    	int x1 = Integer.parseInt(st.nextToken()) - 1;
    	int y2 = Integer.parseInt(st.nextToken()) - 1;
    	int x2 = Integer.parseInt(st.nextToken()) - 1;

    	map = new char[N][M];
    	
    	for(int i = 0; i < N; i++) {
    		map[i] = br.readLine().toCharArray();
    	}
    	
    	System.out.print(dijkstra(x1, y1, x2, y2) + 1);
	}
	public static int dijkstra(int zunanX, int zunanY, int targetX, int targetY) {
		boolean[][] visited = new boolean[N][M];
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
    	pq.add(new int[] {zunanX, zunanY, 0});
    	
    	int[] cur;
    	int xx, yy;
    	while(!pq.isEmpty()) {
    		cur = pq.remove();
    		
    		if(visited[cur[1]][cur[0]]) continue;
    		visited[cur[1]][cur[0]]	 = true;

    		if(cur[0] == targetX && cur[1] == targetY) return cur[2];
    		
    		for(int i = 0; i < 4; i++) {
    			xx = cur[0] + dx[i];
    			yy = cur[1] + dy[i];
    		
    			if(xx < 0 || xx >= M || yy < 0 || yy >= N) continue;
    			if(visited[yy][xx]) continue;
    		
    			if(map[yy][xx] == '1') {
    				pq.add(new int[] {xx, yy, cur[2] + 1});
    			} else {
    				pq.add(new int[] {xx, yy, cur[2]});
    			}
    		}
    	}
    	return -1;
	}
}
