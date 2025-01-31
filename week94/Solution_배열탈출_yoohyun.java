import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[][] nodes;
	static int N;
	static int[] dx = {0,1};
	static int[] dy = {1,0};
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        nodes = new int[N + 1][N + 1];
        
        for(int i = 1; i <= N; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	for(int j = 1; j <= N; j++) {
	    		nodes[i][j] = Integer.parseInt(st.nextToken());
	    	}
        }
        
        boolean[][] visited = new boolean[N + 1][N + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[] {1,1, 0});
        
        int[] cur;
        while(!pq.isEmpty()) {
        	cur = pq.remove();
        	
        	if(visited[cur[1]][cur[0]]) continue;
        	if(cur[0] == N && cur[1] == N) {
        		System.out.print(cur[2]);
        		break;
        	}
        	
        	visited[cur[1]][cur[0]] = true;
        	
        	int xx, yy;
        	for(int k = 0; k < 2; k++) {
        		xx = cur[0] + dx[k];
        		yy = cur[1] + dy[k];
        		
        		if(xx <= 0 || xx > N || yy <= 0 || yy > N) continue;
        		if(visited[yy][xx]) continue;
        		
        		if(nodes[yy][xx] >= nodes[cur[1]][cur[0]]) {
        			pq.add(new int[] {xx, yy, nodes[yy][xx] - nodes[cur[1]][cur[0]] + 1 + cur[2]});
        		} else {
        			pq.add(new int[] {xx, yy, cur[2]});
        		}
        	}
        }
	}
}
