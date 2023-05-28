import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int dp[][];
	static int V, N;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		dp = new int[N + 1][V + 1];
		Thing thing[] = new Thing[N + 1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			thing[i] = new Thing(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for(int i = 1; i <= V; i++ ) {
			for(int j = 1; j <= N; j++) {
				dp[j][i] = dp[j - 1][i];
				if(i - thing[j].weigth >= 0) {
					dp[j][i] = Math.max(dp[j - 1][i], dp[j - 1][i - thing[j].weigth] + thing[j].value);
				}
			}
		}

		System.out.print(dp[N][V]);
	}
	static class Thing {
		int weigth;
		int value;
		Thing(int weight, int value){
			this.weigth = weight;
			this.value = value;
		}
	}
}
