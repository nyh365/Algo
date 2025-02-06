import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[][] map;
	static int N, T;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());

        	for(int j = 0; j < N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        System.out.println(dijkstra());
	}
	
	public static int dijkstra() {
		boolean[][][] visited = new boolean[N][N][3];
        int[][][] minValue = new int[N][N][3];
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		Arrays.fill(minValue[i][j], Integer.MAX_VALUE);
        	}
        }
        
        minValue[0][0][0] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
        a[3] == b[3] ? Integer.compare(a[2], b[2]) : Integer.compare(a[3], b[3]));
        
        pq.add(new int[] {0, 0, 0, minValue[0][0][0]});
        
        int[] cur;
        while(!pq.isEmpty()) {
    		cur = pq.remove();
    		
    		if(visited[cur[1]][cur[0]][cur[2]]) continue;
    		visited[cur[1]][cur[0]][cur[2]] = true;
    		
    		if(cur[0] == N - 1 && cur[1] == N - 1) {
    			return cur[3];
    		}
    		
    		int xx, yy;
    		for(int k = 0 ; k < 4; k++) {
    			xx = cur[0] + dx[k];
    			yy = cur[1] + dy[k];
    			
    			if(xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
    			
    			int hungry = (cur[2] + 1) % 3;
    			
    			if(visited[yy][xx][hungry]) continue;
    			
    			int tmp = hungry == 0 ? map[yy][xx] : 0;
    			tmp += cur[3] + T;
    			
    			if(tmp >= minValue[yy][xx][hungry]) continue;
    			
    			minValue[yy][xx][hungry] = tmp;
    			
    			pq.add(new int[] {xx, yy, hungry, minValue[yy][xx][hungry]});
    		}
    	}
        return -1;
	}
}
