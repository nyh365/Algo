import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
 
public class Main{
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int N = Integer.parseInt(br.readLine());

    	PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    	PriorityQueue<Integer> right = new PriorityQueue<>();
    	
    	int cur;
    	for(int i = 1; i <= N; i++) {
    		cur = Integer.parseInt(br.readLine());
    		if(left.isEmpty()) {
    			left.add(cur);
    		} else {
    			if(left.peek() > cur) left.add(cur);
    			else right.add(cur);
    		}
    		while(left.size() < (i + 1) / 2 ) {
    			left.add(right.remove());
    		}
    		while(right.size() < i / 2 ) {
    			right.add(left.remove());
    		}
    		sb.append(left.peek()).append("\n");
    	}    	
    	System.out.print(sb);
    }
}
