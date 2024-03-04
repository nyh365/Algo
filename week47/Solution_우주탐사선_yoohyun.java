import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int result = Integer.MAX_VALUE;
	static int N;
	static int[] order;
	static int[][] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		dist = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		order = new int[N];
		order[0] = K + 1;
		permutation(1, 1 << (K));
		System.out.println(result);
	}
	static void permutation(int cnt, int flag) {
		if(cnt == N) {
			findRoute();
			return;
		}
		for(int i = 1; i <= N; i++) {
			if((flag & (1 << (i - 1))) > 0) continue;
			order[cnt] = i;
			permutation(cnt + 1, flag | (1 << (i - 1)));
		}
	}
	static void findRoute() {
		int route = 0;
		int start = order[0];
		for(int i = 1; i < N; i++) {
			route += dist[start][order[i]];
			start = order[i];
		}
		result = Math.min(result, route);
	}
}
