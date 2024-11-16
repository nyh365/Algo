import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] orchardSum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		int[][] orchard = new int[N + 1][N + 1];
		orchardSum = new int[N + 1][N + 1];

		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				orchard[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		calculate(orchard);

		int result = Integer.MIN_VALUE;
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N - k + 1; i++) {
				for(int j = 1; j <= N - k + 1; j++) {
					result = Math.max(orchardSum[i + k - 1][j + k - 1] - orchardSum[i - 1][j + k - 1] - orchardSum[i + k - 1][j - 1] + orchardSum[i - 1][j - 1], result);
				}
			}
		}

		System.out.print(result);
	}
	public static void calculate(int[][] orchard) {
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				orchardSum[i][j] = orchardSum[i - 1][j] + orchardSum[i][j - 1] - orchardSum[i - 1][j - 1] + orchard[i][j];
			}
		}
	}
}
