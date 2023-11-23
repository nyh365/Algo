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
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		boolean point[][] = new boolean[N + 1][N + 1];
		boolean check[] = new boolean[N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			point[start][end] = true;
			point[end][start] = true;
		}
		//dfs
		dfs(V, N, point, check);
		System.out.println();
		//bfs
		check = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		check[V] = true;
		System.out.print(V+ " ");
		queue.add(V);
		while(!queue.isEmpty()) {
			int cur = queue.remove();
			for(int i = 1; i <= N; i++) {
				if(point[cur][i] && !check[i]) {
					queue.add(i);
					System.out.print(i + " ");
					check[i] = true;
				}
			}
		}
	}
	public static void dfs(int start, int N, boolean[][] point, boolean[] check) {
		check[start] = true;
		if(start == N + 1) {
			return;
		}
		System.out.print(start + " ");
		for(int i = 1; i <= N; i++) {
			if(point[start][i] && !check[i]) {
				dfs(i, N, point, check);
			}
		}
		
	}
}
