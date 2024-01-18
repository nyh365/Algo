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
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] nodes = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			nodes[from].add(to);
			nodes[to].add(from);
		}
		
		int[] result = new int[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		queue.add(1);
		visited[1] = true;
		while(!queue.isEmpty()) {
			int parent = queue.remove();
			
			for(int i = 0; i < nodes[parent].size(); i++) {
				int child = nodes[parent].get(i);
				if(visited[child]) continue;
				visited[child] = true;
				result[child] = parent;
				queue.add(child);
			}
		}
		
		for(int i = 2; i <= N; i++) {
			sb.append(result[i]).append("\n");
		}
		
		System.out.print(sb);
	}
}
