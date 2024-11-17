import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] mapSum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][M + 1];
		mapSum = new int[N + 1][M + 1];

		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int K = Integer.parseInt(br.readLine());

		calculate(map);

		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());

			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());

			sb.append(mapSum[y2][x2] - mapSum[y1 - 1][x2] - mapSum[y2][x1 - 1] + mapSum[y1 - 1][x1 - 1]).append("\n");
		}

		System.out.print(sb);
	}
	public static void calculate(int[][] map) {
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				mapSum[i][j] = mapSum[i - 1][j] + mapSum[i][j - 1] - mapSum[i - 1][j - 1] + map[i][j];
			}
		}
	}
}
