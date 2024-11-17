import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[] road = new int[N + 1];
		int[] broken = new int[N + 1];
		for(int i = 0; i < B; i++){
			broken[Integer.parseInt(br.readLine())]++;
		}

		int sum = 0;
		for(int i = 1; i <= N; i++) {
			sum += broken[i];
			road[i] = sum;
		}

		int result = Integer.MAX_VALUE;
		for(int i = 1; i <= N - K + 1; i++) {
			result = Math.min(result, road[i + K - 1] - road[i]);
		}

		System.out.print(result);
	}
}
