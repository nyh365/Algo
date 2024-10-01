import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class Main{
	static int[] dx = {0,0,0,-1,1};
	static int[] dy = {0,-1,1,0,0};
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int P = Integer.parseInt(br.readLine());
    	
    	char[] input;
    	int answer;
    	for(int play = 0; play < P; play++) {
    		answer = 0;
    		for(int i = 0; i < 3; i++) {
    			input = br.readLine().toCharArray();
    			for(int j = 0; j < 3; j++) {
    				if(input[j] == '*') {
    					answer |= (1 << (3 * i + j + 1));
    				}
    			}
    		}
    		sb.append(bfs(answer)).append("\n");
    	}
    	System.out.print(sb);
	}
	public static int bfs(int answer) {
		if(answer == 0) return 0;
		
		boolean[] visited = new boolean[1 << 10];
		Queue<int[]> queue = new LinkedList<>();
		
		visited[answer] = true;
		queue.add(new int[] {answer, 1});
		
		int[] cur;
		int xx, yy, temp;
		while(!queue.isEmpty()) {
			cur = queue.remove();
			
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					temp = cur[0];
					
					for(int k = 0; k < 5; k++) {
						xx = j + dx[k];
						yy = i + dy[k];
						
						if(xx < 0 || xx > 2 || yy < 0 || yy > 2) continue;
						
						if((temp & (1 << (3 * yy + xx + 1))) > 0){
							temp &= ~(1 << (3 * yy + xx + 1));
                        } else{
                        	temp |= (1 << (3 * yy + xx + 1));
                        }
					}
					
					if(temp == 0) return cur[1];
					if(visited[temp]) continue;
					visited[temp] = true;
					queue.add(new int[] {temp, cur[1] + 1});
				}
			}
		}
		return -1;
	}
}
