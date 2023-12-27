import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int my = Integer.parseInt(br.readLine());
		int result = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 1; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		if(!pq.isEmpty()) {
			while(true) {
				int cur = pq.poll();
				if(my > cur) break;
				else {
					result++;
					pq.add(cur - 1);
					my++;
				}
			}
		} 
		System.out.println(result);
	}
}
