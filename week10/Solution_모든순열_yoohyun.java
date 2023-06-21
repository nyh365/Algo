import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr, order;
	static int N;
	static StringBuilder sb;
	static boolean[] visited;
	static int result = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		
		order = new int[N];
		visited = new boolean[N];
		sb = new StringBuilder();
		dfs(0);
		System.out.println(sb);
	}
	public static void dfs(int cnt) {
		if(cnt == N) {
			cal();
			return;
		}
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			order[cnt] = arr[i];
			dfs(cnt + 1);
			visited[i] = false;
		}
	}
	public static void cal() {
		for(int i = 0; i < N; i++) {
			sb.append(order[i]).append(" ");
		}
		sb.append("\n");
	}
}

  
