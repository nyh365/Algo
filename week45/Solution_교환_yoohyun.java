import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main{
	static boolean[][] visited = new boolean[1000001][11];
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	char[] N = st.nextToken().toCharArray();
    	int K = Integer.parseInt(st.nextToken());
   
    	int length = N.length;
    	
    	Queue<Integer> queue = new LinkedList<>();
    	queue.add(Integer.parseInt(String.valueOf(N))); queue.add(0);
    	
    	int result = Integer.MIN_VALUE;
    	int cur, swapCnt, next;
    	while(!queue.isEmpty()) {
    		cur = queue.remove();
    		swapCnt = queue.remove();
    		
    		if(swapCnt == K) {
    			result = Math.max(result, cur);
    			continue;
    		}
    		
    		for(int i = 0; i < length; i++) {
    			for(int j = i + 1; j < length; j++) {
    				next = swap(cur, i, j);
    				if(next == -1) continue;
    				if(visited[next][swapCnt + 1]) continue;
    				
    				visited[next][swapCnt + 1] = true;
    				queue.add(next);
    				queue.add(swapCnt + 1);
    			}
    		}
    			
    	}
    	System.out.print(result == Integer.MIN_VALUE ? -1 : result);
    }
	public static int swap(int num, int i, int j) {
		char[] number = String.valueOf(num).toCharArray();
		char temp = number[i];
		number[i] = number[j];
		number[j] = temp;
		
		if(number[0] == '0') return -1;
		return Integer.parseInt(String.valueOf(number));
	}
}
