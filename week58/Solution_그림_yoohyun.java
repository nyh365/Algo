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
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
    
        int[][] paint = new int[n][m];
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < m; j++) {
        		paint[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        boolean[][] visited = new boolean[n][m];
        int total = 0, max_size = 0;
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < m; j++) {
        		if(visited[i][j] || paint[i][j] != 1) continue;
        		total++;
        		visited[i][j] = true;
        		
        		max_size = Math.max(max_size, BFS(j, i, n, m, visited, paint));
        	}
        }
        System.out.print(total + "\n" + max_size);
	}
	
	public static int BFS(int x, int y, int n, int m, boolean[][] visited, int[][] paint) {
		int[] cur;
		int xx, yy;
		int result = 0;
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {x, y});
		while(!queue.isEmpty()) {
			cur = queue.remove();	
			
			for(int k = 0; k < 4; k++) {
				xx = cur[0] + dx[k];
				yy = cur[1] + dy[k];
				
				if(xx < 0 || xx >= m || yy < 0 || yy >= n) continue;
				if(visited[yy][xx]) continue;
				if(paint[yy][xx] != 1) continue;
				result++;
				visited[yy][xx] = true;
				queue.add(new int[] {xx,yy});
			}
		}
		
		return result + 1;
	}
}
