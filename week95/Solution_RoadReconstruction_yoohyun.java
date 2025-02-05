import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[][] map;
	static int N, M;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());

        	for(int j = 0; j < N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        System.out.println(dijkstra());
	}
	
	public static int dijkstra() {
		boolean[][] visited = new boolean[M][N];
        int[][] minValue = new int[M][N];
        
        for(int i = 0; i < M; i++) {
        	Arrays.fill(minValue[i], Integer.MAX_VALUE);
        }
        
        if(map[0][0] == -1) return -1;
        minValue[0][0] = map[0][0];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[] {0,0, minValue[0][0]});
        
        int[] cur;
        while(!pq.isEmpty()) {
    		cur = pq.remove();
    		
    		if(visited[cur[1]][cur[0]]) continue;
    		visited[cur[1]][cur[0]] = true;
    		
    		if(cur[0] == N - 1 && cur[1] == M - 1) {
    			return cur[2];
    		}
    		
    		int xx, yy;
    		for(int k = 0 ; k < 4; k++) {
    			xx = cur[0] + dx[k];
    			yy = cur[1] + dy[k];
    			
    			if(xx < 0 || xx >= N || yy < 0 || yy >= M) continue;
    			if(visited[yy][xx]) continue;
    			if(map[yy][xx] == -1) continue;
    			if(minValue[cur[1]][cur[0]] + map[yy][xx] >= minValue[yy][xx]) continue;
    			
    			minValue[yy][xx]= minValue[cur[1]][cur[0]] + map[yy][xx];
    			
    			pq.add(new int[] {xx, yy, minValue[yy][xx]});
    		}
    	}
        return -1;
	}
}
