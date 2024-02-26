import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]>[] videos = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++) {
			videos[i] = new ArrayList<>();
		}
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
		
			videos[p].add(new int[] {q,r});
			videos[q].add(new int[] {p,r});
		}
		
		for(int question = 0; question < Q; question++) {
			int result = 0;
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			boolean[] visited = new boolean[N + 1];
			Queue<Integer> queue = new LinkedList<>();
			queue.add(v);
			visited[v] = true;
			while(!queue.isEmpty()) {
				int cur = queue.remove();
				
				for(int i = 0; i < videos[cur].size(); i++) {
					int[] video = videos[cur].get(i);
					if(visited[video[0]]) continue;
					if(video[1] >= k) {
						visited[video[0]] = true;
						queue.add(video[0]);
						result++;
					}
				}
			}
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
}
