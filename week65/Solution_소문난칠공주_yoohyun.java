import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class Main{
	static char[][] seat = new char[5][5];
	static boolean[][] choose = new boolean[5][5];
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
  static int result;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < 5; i++) {
        	seat[i] = br.readLine().toCharArray();
        }
        
        combination(0,0,0);
        
        System.out.println(result);
    }
    public static void combination(int N, int cntY, int cur) {
    	if(cntY > 3) return;
    	if(N == 7) {
    		isConnected();
    		return;
    	}
    	
    	for(int i = cur; i < 25; i++) {
    		choose[i / 5][i % 5] = true;
    		if(seat[i / 5][i % 5] == 'Y') {
    			combination(N + 1, cntY + 1, i + 1);
    		} else {
    			combination(N + 1, cntY, i + 1);
    		}
    		choose[i / 5][i % 5] = false;
    	}
    }    
    public static void isConnected() {
    	Queue<int[]> queue = new LinkedList<>();
    	boolean[][] visited = new boolean[5][5];
    	int cnt = 0;
    	
    	for(int i = 0; i < 5; i++) {
    		for(int j = 0; j < 5; j++) {
    			if(choose[i][j]) {
    				queue.add(new int[] {j, i});
    				cnt++;
    				visited[i][j] = true;
    				
    				int[] cur;
    				int xx, yy;
    				while(!queue.isEmpty()) {
    					cur = queue.remove();
    					
    					for(int k = 0; k < 4; k++) {
    						xx = cur[0] + dx[k];
    						yy = cur[1] + dy[k];
    						
    						if(xx < 0 || xx > 4 || yy < 0 || yy > 4) continue;
    						if(visited[yy][xx]) continue;
    						if(!choose[yy][xx]) continue;
    						
    						visited[yy][xx] = true;
    						cnt++;
    						queue.add(new int[] {xx, yy});
    					}
    				}
        			result += (cnt == 7 ? 1 : 0);
        			return;
    			}
    		}
    	}
    }
}
