import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main{
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int[][] iceberg;
	static int N, M;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        iceberg = new int[N][M];
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < M; j++) {
        		iceberg[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        int result = 0, temp;
        while(true) {
        	temp = count();
        	if(temp >= 2) {
        		System.out.print(result);
        		break;
        	} else if(temp == 0) {
        		System.out.print(0);
        		break;
        	}
        	result++;
        }
    }
	public static int count() {
		boolean[][] visited = new boolean[N][M];
		
		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(visited[i][j]) continue;
				if(iceberg[i][j] <= 0) continue;
				result++;
				visited[i][j] = true;
				bfs(j, i, visited);
			}
		}
		
		return result;
	}
	public static void bfs(int x, int y, boolean[][] visited) {
		int[] cur;
		int xx, yy, cnt;
		Queue<int[]> locs = new LinkedList<>();
		Queue<int[]> melting = new LinkedList<>();
		
		locs.add(new int[] {x,y});
		while(!locs.isEmpty()) {
			cur = locs.remove();
			
			cnt = 0;
			for(int k = 0; k < 4; k++) {
				xx = cur[0] + dx[k];
				yy = cur[1] + dy[k];
				
				if(xx < 0 || xx >= M || yy < 0 || yy >= N) continue;
				if(iceberg[yy][xx] <= 0) {
					cnt++;
				} else {
					if(!visited[yy][xx]) {
						locs.add(new int[] {xx,yy});
						visited[yy][xx] = true;
					}
				}
			}
			melting.add(new int[] {cur[0], cur[1], cnt});
		}
			
		while(!melting.isEmpty()) {
			cur = melting.remove();
			iceberg[cur[1]][cur[0]] -= cur[2];
		}
	}
}
