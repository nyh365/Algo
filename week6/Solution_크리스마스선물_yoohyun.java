import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0; i < N; i++) {
			String in = br.readLine();
			int input = Integer.parseInt(in.split(" ")[0]);
			if(input == 0) {
				if(pq.isEmpty())
					System.out.println(-1);
				else {
					System.out.println(pq.poll());
				}
			}
			else {
				for(int j = 1; j <= input; j++) {
					pq.add(Integer.parseInt(in.split(" ")[j]));
				}
			}
		}
	}
}
