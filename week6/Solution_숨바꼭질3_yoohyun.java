import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> queue1 = new LinkedList<>();
		Queue<Integer> queue2 = new LinkedList<>();
		int result[] = new int[200001];
		boolean check[] = new boolean[200001];
		result[N] = 0;
		check[N] = true;
		queue1.add(N);
		while(!queue1.isEmpty()) {
			int cur = queue1.remove();
			if(cur * 2 < 200001) {
				if(!check[cur * 2]) {
					queue1.add(cur * 2);
					check[cur * 2] = true;
					result[cur * 2] = result[cur];
				}
			}
			if(cur + 1 < 200001) {
				if(!check[cur + 1]) {
					queue2.add(cur + 1);
					check[cur + 1] = true;
					result[cur + 1] = result[cur] + 1;
				}
			}
			if(cur - 1 >= 0) {
				if(!check[cur - 1]) {
					queue2.add(cur - 1);
					check[cur - 1] = true;
					result[cur - 1] = result[cur] + 1;
				}
			}
			
			if(queue1.isEmpty()) {
				while(!queue2.isEmpty()) {
					queue1.add(queue2.remove());
				}
			}
		}
		
		System.out.print(result[K]);
	}
}
