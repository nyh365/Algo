import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main{
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int N, M, total;
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	map = new int[N][M];
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < M; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			if(map[i][j] == 1) {
    				total++;
    			}
    		}
    	}
    	

    	int result = 0;
    	while(total != 0) {
    		findInterCheese();
    		meltingCheese();
    		result++;
    	}
    	System.out.print(result);
    }
	public static void findInterCheese() {
		boolean[][] visited = new boolean[N][M];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0); queue.add(0);
		visited[0][0] = true;
		
		int x, y, xx, yy;
		while(!queue.isEmpty()) {
			x = queue.remove();
			y = queue.remove();
			
			for(int i = 0; i < 4; i++) {
				xx = x + dx[i];
				yy = y + dy[i];
				
				if(xx < 0 || xx >= M || yy < 0 || yy >= N) continue;
				if(map[yy][xx] == 1) continue;
				if(visited[yy][xx]) continue;
				visited[yy][xx] = true;
				map[yy][xx] = 2;
				queue.add(xx); queue.add(yy);
			}
		}
	}
	
	public static void meltingCheese() {
		int xx, yy, cnt;
		LinkedList<int[]> removeCheese = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 1) continue;
				cnt = 0;
				for(int k = 0; k < 4; k++) {
					xx = j + dx[k];
					yy = i + dy[k];
					
					if(xx < 0 || xx >= M || yy < 0 || yy >= N) continue;
					if(map[yy][xx] == 2) cnt++;
				}
				if(cnt > 1) {
					removeCheese.add(new int[] {j,i});
				}
			}
		}
		for(int[] loc : removeCheese) {
			total--;
			map[loc[1]][loc[0]] = 2;
		}
	}
}
