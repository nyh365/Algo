import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main{
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());

    	int[][] map = new int[N][M];
    	boolean[][][] visited = new boolean[N][M][11];
    	
    	
    	char[] input;
    	for(int i = 0; i < N; i++) {
    		input = br.readLine().toCharArray();
    		for(int j = 0; j < M; j++) {
    			map[i][j] = input[j] - '0';
    		}
    	}
    	
    	Queue<Integer> queue = new LinkedList<>();
    	queue.add(0); queue.add(0); queue.add(K); queue.add(1);
    	visited[0][0][K] = true;
    	
    	int result = -1;
    	
    	int x, y, k, cost;
    	int xx, yy;
    	while(!queue.isEmpty()) {
    		x = queue.remove(); y = queue.remove(); k = queue.remove(); cost = queue.remove();
    		
    		if(x == M - 1 && y == N - 1) {
    			result = cost;
    			break;
    		}
    		
    		for(int i = 0; i < 4; i++) {
    			xx = x + dx[i]; yy = y + dy[i];
    			
    			if(xx < 0 || xx >= M || yy < 0 || yy >= N) continue;
    			if(visited[yy][xx][k]) continue;
    			if(map[yy][xx] == 1 && k < 1) continue;
    			
    			visited[yy][xx][k] = true;
    			queue.add(xx); queue.add(yy); queue.add(map[yy][xx] == 1 ? k - 1 : k); queue.add(cost + 1);
    		}
    	}
    	
    	System.out.print(result);
    }
}
