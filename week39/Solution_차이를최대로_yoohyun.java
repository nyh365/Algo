import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr, order;
	static int N;
	static boolean[] visited;
	static int result = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		order = new int[N];
		visited = new boolean[N];
		dfs(0);
		System.out.println(result);
	}
	public static void dfs(int cnt) {
		if(cnt == N) {
			cal();
			return;
		}
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			order[cnt] = i;
			dfs(cnt + 1);
			visited[i] = false;
		}
	}
	public static void cal() {
		int temp = 0;
		for(int i = 0; i < N - 1; i++) {
			temp += Math.abs(arr[order[i]] - arr[order[i + 1]]);
		}
		result = Math.max(result, temp);
	}
}

