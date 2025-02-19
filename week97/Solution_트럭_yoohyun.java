import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> weight = new LinkedList<>();
        
        for(int i = 0; i < W; i++) {
        	bridge.add(0);
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	weight.add(Integer.parseInt(st.nextToken()));
        }
        
        int result = 0, total = 0, truck;
        while(!weight.isEmpty() || !bridge.isEmpty()) {
        	result++;
        	
        	truck = bridge.remove();
        	total -= truck;
        	
        	if(!weight.isEmpty()) {
        		if(total + weight.peek() <= L) {
            		truck = weight.remove();
            		total += truck;
            		bridge.add(truck);
            	} else {
            		bridge.add(0);
            	}
        	}
        }
        
        
        System.out.println(result);
	}
}
