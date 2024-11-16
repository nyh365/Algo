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
		int M = Integer.parseInt(st.nextToken());

		int[] sand = new int[N + 1];
		int[] height = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			sand[i] = Integer.parseInt(st.nextToken());
		}

		for(int q = 0; q < M; q++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			height[a] += k;
			if(b == N) continue;;

			height[b + 1] -= k;
		}

		int work = 0;
		for(int i = 1; i <= N; i++) {
			work += height[i];
			sb.append(sand[i] + work).append(" ");
		}

		System.out.print(sb);
	}
}
