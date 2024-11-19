import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][3];
		int[][] dp_max = new int[N][3];
		int[][] dp_min = new int[N][3];

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());

			for(int j = 0; j < 3; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < 3; i++){
			dp_max[0][i] = map[0][i];
			dp_min[0][i] = map[0][i];
		}

		for (int i = 1; i < N; i++) {
			dp_max[i][0] = Math.max(dp_max[i - 1][0], dp_max[i - 1][1]) + map[i][0];
			dp_max[i][1] = Math.max(Math.max(dp_max[i - 1][0], dp_max[i - 1][1]), dp_max[i - 1][2]) + map[i][1];
			dp_max[i][2] = Math.max(dp_max[i - 1][1], dp_max[i - 1][2]) + map[i][2];

			dp_min[i][0] = Math.min(dp_min[i - 1][0], dp_min[i - 1][1]) + map[i][0];
			dp_min[i][1] = Math.min(Math.min(dp_min[i - 1][0], dp_min[i - 1][1]), dp_min[i - 1][2]) + map[i][1];
			dp_min[i][2] = Math.min(dp_min[i - 1][1], dp_min[i - 1][2]) + map[i][2];
		}

		int max = Math.max(Math.max(dp_max[N - 1][0], dp_max[N - 1][1]), dp_max[N - 1][2]);
		int min = Math.min(Math.min(dp_min[N - 1][0], dp_min[N - 1][1]), dp_min[N - 1][2]);
		System.out.print(max + " " + min);
	}
}
