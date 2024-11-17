import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] work = new long[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			work[i] = Long.parseLong(st.nextToken());
			work[i] += work[i - 1];
		}

		long result = Integer.MIN_VALUE;
		for(int i = 1; i <= N - M + 1; i++) {
			result = Math.max(result, work[i + M - 1] - work[i - 1]);
		}

		System.out.print(result);
	}
}
