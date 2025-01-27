import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static final int size = 500;
	static LinkedList<int[]> dangerousArea, deathArea;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        dangerousArea = new LinkedList<>();
        deathArea = new LinkedList<>();
        
        int N = Integer.parseInt(br.readLine());
        int x1, y1, x2, y2;
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());

        	x1 = Integer.parseInt(st.nextToken());
        	y1 = Integer.parseInt(st.nextToken());
        	x2 = Integer.parseInt(st.nextToken());
        	y2 = Integer.parseInt(st.nextToken());
        
        	dangerousArea.add(new int[] {x1, y1, x2, y2});
        }
        
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());

        	x1 = Integer.parseInt(st.nextToken());
        	y1 = Integer.parseInt(st.nextToken());
        	x2 = Integer.parseInt(st.nextToken());
        	y2 = Integer.parseInt(st.nextToken());
        
        	deathArea.add(new int[] {x1, y1, x2, y2});
        }
        
        boolean[][] visited = new boolean[size + 1][size + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[] {0,0,0});
        
        int[] cur;
        while(!pq.isEmpty()) {
        	cur = pq.remove();
        	
        	if(cur[0] == size && cur[1] == size) {
        		System.out.print(cur[2]);
        		return;
        	}
        	
        	if(visited[cur[1]][cur[0]]) continue;
        	visited[cur[1]][cur[0]] = true;
        	
        	int xx, yy, score;
        	for(int i = 0; i < 4; i++) {
        		xx = cur[0] + dx[i];
        		yy = cur[1] + dy[i];

        		if(xx < 0 || xx > size || yy < 0 || yy > size) continue;
        		if(visited[yy][xx]) continue;
        		
        		score = getScore(xx, yy);
        		
        		if(score == -1) continue;
        		pq.add(new int[] {xx, yy, cur[2] + score});
        	}
        }
        
        System.out.print(-1);
    }
	
	public static int getScore(int x, int y) {
		int score = 0;
		
		for(int[] area : dangerousArea) {
			if(area[0] <= x && area[1] <= y && x <= area[2] && y <= area[3]) {
				score = 1;
				break;
			}
		}
		
		for(int[] area : deathArea) {
			if(area[0] <= x && area[1] <= y && x <= area[2] && y <= area[3]) {
				score = -1;
				break;
			}
		}
		
		return score;
	}

}
