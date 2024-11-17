import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 1; i <= N; i++) {
			num[i] += num[i - 1];
		}

		int Q = Integer.parseInt(br.readLine());
		for(int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());

			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			sb.append(num[j] - num[i - 1]).append("\n");
		}

		System.out.print(sb);
	}
}
