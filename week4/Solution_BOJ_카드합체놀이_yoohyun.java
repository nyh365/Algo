import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}
		
		
		for(int i = 0; i < M; i++) {
			Long x = pq.poll();
			Long y = pq.poll();
			pq.add(x + y);
			pq.add(x + y);
		}
		Long result = 0L;
		for(int i = 0; i < N; i++) {
			result += pq.poll();
		}
		System.out.println(result);
	}
}
