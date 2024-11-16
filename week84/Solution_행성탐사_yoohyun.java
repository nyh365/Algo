import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	// 0은 정글, 1은 바다, 2는 얼음
	static int[][][] mapSum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(br.readLine());

		char[][] map = new char[N + 1][M + 1];
		mapSum = new int[N + 1][M + 1][3];

		char[] input;
		for(int i = 1; i <= N; i++) {
			input = br.readLine().toCharArray();
			for(int j = 1; j <= M; j++) {
				map[i][j] = input[j - 1];
			}
		}

		calculate(map);

		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());

			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());

			for(int i = 0; i < 3; i++){
				sb.append(mapSum[y2][x2][i] - mapSum[y1 - 1][x2][i] - mapSum[y2][x1 - 1][i] + mapSum[y1 - 1][x1 - 1][i]).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}
	public static void calculate(char[][] map) {
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				mapSum[i][j][0] = mapSum[i - 1][j][0] + mapSum[i][j - 1][0] - mapSum[i - 1][j - 1][0] + (map[i][j] == 'J' ? 1 : 0);
				mapSum[i][j][1] = mapSum[i - 1][j][1] + mapSum[i][j - 1][1] - mapSum[i - 1][j - 1][1] + (map[i][j] == 'O' ? 1 : 0);
				mapSum[i][j][2] = mapSum[i - 1][j][2] + mapSum[i][j - 1][2] - mapSum[i - 1][j - 1][2] + (map[i][j] == 'I' ? 1 : 0);
			}
		}
	}
}
