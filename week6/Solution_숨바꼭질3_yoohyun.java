import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = 100000;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		boolean[] visited = new boolean[MAX + 1];
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
		pq.add(new int[] {n, 0});
		
		int[] tmp;
		while(!pq.isEmpty()) {
			tmp = pq.remove();
			
			if(visited[tmp[0]]) continue;
			visited[tmp[0]] = true;
			
			if(tmp[0] == k) {
				answer = tmp[1];
				break;
			}
			
			if(tmp[0] - 1 >= 0) {
				if(!visited[tmp[0] - 1]) {
					pq.add(new int[] {tmp[0] - 1, tmp[1] + 1});
				}
			}
			
			if(tmp[0] + 1 <= MAX) {
				if(!visited[tmp[0] + 1]) {
					pq.add(new int[] {tmp[0] + 1, tmp[1] + 1});
				}
			}
			
			if(tmp[0] * 2 <= MAX) {
				if(!visited[tmp[0] * 2]) {
					pq.add(new int[] {tmp[0] * 2, tmp[1]});
				}
			}
		}
		System.out.print(answer);
    }
}
