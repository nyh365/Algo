import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int result = 1;
		PriorityQueue<Integer> prize = new PriorityQueue<>(Collections.reverseOrder());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			prize.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			int want = Integer.parseInt(st.nextToken());
			want = prize.poll() - want;
			if(want > 0)
				prize.add(want);
			else if(want < 0) {
				result = 0;
				break;
			}
		}
		
		System.out.println(result);
	}
}
