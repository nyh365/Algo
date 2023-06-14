import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] stats;
	static boolean[] order;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		stats = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				stats[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		order = new boolean[N];
		dfs(0, 0);
		System.out.print(result);
	}
	public static void dfs(int idx, int cnt) {
		if(cnt == N / 2) {
			cal();
			return;
		}
		for(int i = idx; i < N; i++) {
			if(order[i]) continue;
			order[i] = true;
			dfs(i + 1, cnt + 1);
			order[i] = false;
		}
	}
	
	public static void cal() {
		int sumA = 0, sumB = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(order[i] && order[j]) sumA += stats[i][j];
				else if(!order[i] && !order[j]) sumB += stats[i][j];
			}
		}
		result = Math.min(result, Math.abs(sumA - sumB));
	}
}

