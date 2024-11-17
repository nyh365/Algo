import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[] num;
		int Q = Integer.parseInt(br.readLine());
		for(int q = 0; q < Q; q++) {
			int N = Integer.parseInt(br.readLine());
			num = new int[N + 1];

			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
				num[i] += num[i - 1];
			}

			int result = Integer.MIN_VALUE;
			for(int i = 1; i <= N; i++) {
				for(int j = i; j <= N; j++) {
					result = Math.max(result, num[j] - num[i - 1]);
				}
			}

			sb.append(result).append("\n");
		}

		System.out.print(sb);
	}
}
