import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int MAX_TIME = 1000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] timeTable = new int[MAX_TIME + 1];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			timeTable[S] += 1;

			if(E == MAX_TIME) continue;
			timeTable[E + 1] -= 1;
		}

		for(int i = 1; i <= MAX_TIME; i++) {
			timeTable[i] += timeTable[i - 1];
		}

		int Q = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < Q; i++) {
			sb.append(timeTable[Integer.parseInt(st.nextToken())]).append("\n");
		}

		System.out.print(sb);
	}
}
