import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] result;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		int[] sheet = new int[N + 1];
		result = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			sheet[i] = Integer.parseInt(st.nextToken());
		}

		calculate(sheet);

		int Q = Integer.parseInt(br.readLine());

		for(int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			sb.append(result[y - 1] - result[x - 1]).append("\n");
		}

		System.out.println(sb);
	}
	public static void calculate(int[] sheet){
		for(int i = 1; i < N; i++) {
			result[i] = result[i - 1];

			if(sheet[i] > sheet[i + 1]) {
				result[i]++;
			}
		}
	}
}
