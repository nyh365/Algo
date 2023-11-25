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
		Queue<Integer> queue = new LinkedList<>();
		boolean check[] = new boolean[200001];
		int result[] = new int[200001];
		check[N] = true;
		result[N] = 0;
		queue.add(N);
		while(!queue.isEmpty()) {
			int cur = queue.remove();
			if(cur - 1 >=0 ) {
				if(!check[cur - 1]) {
					queue.add(cur - 1);
					check[cur - 1] = true;
					result[cur - 1] = result[cur] + 1;
				}
			}
			if(cur + 1 <= 200000) {
				if(!check[cur + 1]) {
					queue.add(cur + 1);
					check[cur + 1] = true;
					result[cur + 1] = result[cur] + 1;
				}
			}
			if(cur * 2 <= 200000) {
				if(!check[cur * 2]) {
					queue.add(cur * 2);
					check[cur * 2] = true;
					result[cur * 2] = result[cur] + 1;
				}
			}
		}
		System.out.println(result[K]);
	}
}
