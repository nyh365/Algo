import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] volume = new int[N + 1];
		boolean[][] dp = new boolean[M + 1][N + 1];

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++){
			volume[i] = Integer.parseInt(st.nextToken());
		}

		dp[S][0] = true;

		for(int i = 1; i <= N; i++){
			for(int j = 0; j <= M; j++){
				if(!dp[j][i - 1]) {
					continue;
				}

				if(j + volume[i] <= M){
					dp[j + volume[i]][i] = true;
				}

				if(j - volume[i] >= 0){
					dp[j - volume[i]][i] = true;
				}
			}
		}

		for(int i = M; i >= 0; i--){
			if(dp[i][N]) {
				System.out.print(i);
				return;
			}
		}

		System.out.print(-1);
	}
}
