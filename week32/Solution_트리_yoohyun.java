import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	public static ArrayList<Integer>[] nodes;
	public static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		nodes = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		int root = -1;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int to = Integer.parseInt(st.nextToken());
			if(to == -1) {
				root = i;
				continue;
			}
			nodes[to].add(i);
		}
		
		int remove = Integer.parseInt(br.readLine());
		int result = 0;
		visited = new boolean[N];
		if(remove != root) {
			visited[root] = true;
			visited[remove] = true;
			result = dfs(root);
		}

		System.out.print(result);
	}
	public static int dfs(int parent) {
		if(nodes[parent].size() == 0) return 1;
		else {
			int cnt = 0;
			for(int i = 0; i < nodes[parent].size(); i++) {
				int vertex = nodes[parent].get(i);
				if(visited[vertex]) continue;
				visited[vertex] = true;
				cnt += dfs(vertex);
			}
			return cnt == 0 ? 1 : cnt;
		}
	}
}
