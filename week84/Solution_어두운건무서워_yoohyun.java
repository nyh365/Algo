import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] pixelSum;
	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int[][] picture = new int[R + 1][C + 1];
		pixelSum = new int[R + 1][C + 1];

		for(int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());

			for(int j = 1; j <= C; j++) {
				picture[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		calculate(picture);

		for(int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());

			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());

			int bright = pixelSum[y2][x2] - pixelSum[y1 - 1][x2] - pixelSum[y2][x1 - 1] + pixelSum[y1 - 1][x1 - 1];

			sb.append(bright / ((x2 - x1 + 1) * (y2 - y1 + 1))).append("\n");
		}

		System.out.println(sb);
	}
	public static void calculate(int[][] picture){
		for(int i = 1; i <= R; i++) {
			for(int j = 1; j <= C; j++) {
				pixelSum[i][j] = pixelSum[i - 1][j] + pixelSum[i][j - 1] - pixelSum[i - 1][j - 1] + picture[i][j];
			}
		}
	}
}
